package com.example.network.model

import com.example.model.Listing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkListing(
    @SerialName("id") val id: String,
    @SerialName("offerType") val offerType: String,
    @SerialName("categories") val categories: List<String>,
    @SerialName("prices") val prices: NetworkPrices,
    @SerialName("address") val address: NetworkAddress,
    @SerialName("characteristics") val characteristics: NetworkCharacteristics,
    @SerialName("localization") val localization: NetworkLocalization,
    @SerialName("lister") val lister: NetworkLister
)

// Added extension function
fun NetworkListing.asDomain(): Listing = Listing(
    id = id,
    offerType = offerType,
    categories = categories,
    prices = prices.asDomain(),
    address = address.asDomain(),
    characteristics = characteristics.asDomain(),
    localization = localization.asDomain(),
    lister = lister.asDomain()
) 