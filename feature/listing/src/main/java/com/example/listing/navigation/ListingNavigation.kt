package com.example.listing.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.listing.RealEstateListingRoute
import com.example.listing.RealEstateListingViewModel
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object Listing

@Serializable
internal data object ListingScreen

fun NavGraphBuilder.listingGraph() {
    navigation<Listing>(
        startDestination = ListingScreen
    ) {
        composable<ListingScreen> {
            val viewModel = koinViewModel<RealEstateListingViewModel>()
            RealEstateListingRoute(viewModel = viewModel)
        }
    }
}
