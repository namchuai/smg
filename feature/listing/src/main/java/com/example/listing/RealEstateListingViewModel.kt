package com.example.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.BookmarkRealEstateUseCase
import com.example.domain.DeleteBookmarkRealEstateUseCase
import com.example.domain.GetBookmarkPropertiesUseCase
import com.example.domain.GetRealEstatesListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal

class RealEstateListingViewModel(
    getBookmarkPropertiesUseCase: GetBookmarkPropertiesUseCase,
    getRealEstatesListUseCase: GetRealEstatesListUseCase,
    private val bookmarkRealEstateUseCase: BookmarkRealEstateUseCase,
    private val deleteBookmarkRealEstateUseCase: DeleteBookmarkRealEstateUseCase,
) : ViewModel() {

    private var _state = MutableStateFlow(RealEstateUiState())
    val state: StateFlow<RealEstateUiState> = _state
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = RealEstateUiState(),
        )

    fun onBookmarkClick(id: String) {
        viewModelScope.launch {
            _state.value.realEstateList.find { it.id == id }?.let {
                if (it.bookmarked) {
                    deleteBookmarkRealEstateUseCase(id)
                } else {
                    bookmarkRealEstateUseCase(id)
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
                    val localizedData = realEstate.listing.localization.locales[realEstate.listing.localization.primary]!!
                    RealEstateItem(
                        id = realEstate.id,
                        title = localizedData.text.title,
                        pricing = BigDecimal(realEstate.listing.prices.buy?.price ?: 0),
                        thumbnailUrls = localizedData.attachments
                            .filter { it.type == "IMAGE" }
                            .map { it.url },
                        bookmarked = bookmarkedIds.contains(realEstate.id)
                    )
                }
        }
        .onEach { mappedList ->
            _state.update { it.copy(realEstateList = mappedList) }
        }
        .launchIn(viewModelScope)
    }
}