package com.example.listing

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.BookmarkRealEstateUseCase
import com.example.domain.DeleteBookmarkRealEstateUseCase
import com.example.domain.GetBookmarkPropertiesUseCase
import com.example.domain.GetRealEstatesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.math.BigDecimal

class RealEstateListingViewModel(
    getBookmarkPropertiesUseCase: GetBookmarkPropertiesUseCase,
    getRealEstatesListUseCase: GetRealEstatesListUseCase,
    private val bookmarkRealEstateUseCase: BookmarkRealEstateUseCase,
    private val deleteBookmarkRealEstateUseCase: DeleteBookmarkRealEstateUseCase,
) : ViewModel() {

    private var _state = MutableStateFlow<AsyncState<RealEstateUiState>>(AsyncState.Loading)
    val state: StateFlow<AsyncState<RealEstateUiState>> = _state.asStateFlow()

    fun onBookmarkClick(id: String) {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState is AsyncState.Success) {
                currentState.data.realEstateList.find { it.id == id }?.let {
                    if (it.bookmarked) {
                        deleteBookmarkRealEstateUseCase(id)
                    } else {
                        bookmarkRealEstateUseCase(id)
                    }
                }
            }
        }
    }

    init {
        combine(
            getRealEstatesListUseCase(),
            getBookmarkPropertiesUseCase()
        ) { realEstates, bookmarkedIds ->
            realEstates
                .filter { realEstate ->
                    realEstate.listing.localization.locales[realEstate.listing.localization.primary] != null
                }
                .map { realEstate ->
                    val localizedData =
                        realEstate.listing.localization.locales[realEstate.listing.localization.primary]!!
                    RealEstateItem(
                        id = realEstate.id,
                        title = localizedData.text.title,
                        pricing = Money(
                            amount = BigDecimal(realEstate.listing.prices.buy?.price ?: 0),
                            currencyCode = realEstate.listing.prices.currency,
                        ),
                        thumbnailUrls = localizedData.attachments
                            .filter { it.type == "IMAGE" }
                            .map { it.url },
                        bookmarked = bookmarkedIds.contains(realEstate.id),
                        latitude = realEstate.listing.address.geoCoordinates?.latitude,
                        longitude = realEstate.listing.address.geoCoordinates?.longitude,
                        address = with(realEstate.listing.address) {
                            listOfNotNull(
                                street,
                                "$postalCode $locality",
                                region,
                                country
                            ).joinToString(", ")
                        }
                    )
                }
        }.onEach { mappedList ->
            _state.value = AsyncState.Success(RealEstateUiState(realEstateList = mappedList))
        }.catch { e ->
            Log.e("RealEstateListingViewModel", "Error fetching data", e)
            _state.value = AsyncState.Error("An unknown error occurred. Please try again later.")
        }.launchIn(viewModelScope)
    }
}