package com.example.smgrealestate.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.listing.navigation.Listing
import com.example.listing.navigation.listingGraph

@Composable
fun SMGNavGraph(
    modifier: Modifier = Modifier,
    startDestination: Any = Listing,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        startDestination = startDestination,
        navController = navController,
    ) {
        listingGraph()
    }
}