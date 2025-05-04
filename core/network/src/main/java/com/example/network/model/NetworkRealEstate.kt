package com.example.network.model

import com.example.model.RealEstate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkRealEstate(
    @SerialName("id") val id: String,
    @SerialName("remoteViewing") val remoteViewing: Boolean,
    @SerialName("listingType") val listingType: NetworkListingType,
    @SerialName("listerBranding") val listerBranding: NetworkListerBranding? = null, // Nullable
    @SerialName("listing") val listing: NetworkListing
)

// Added extension function
fun NetworkRealEstate.asDomain(): RealEstate = RealEstate(
    id = id,
    remoteViewing = remoteViewing,
    listingType = listingType.asDomain(),
    listerBranding = listerBranding?.asDomain(), // Handle nullable
    listing = listing.asDomain()
) 