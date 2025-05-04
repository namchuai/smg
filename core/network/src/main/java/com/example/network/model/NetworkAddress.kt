package com.example.network.model

import com.example.model.Address
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAddress(
    @SerialName("locality") val locality: String,
    @SerialName("country") val country: String,
    @SerialName("region") val region: String? = null, // Nullable
    @SerialName("street") val street: String? = null, // Nullable
    @SerialName("postalCode") val postalCode: String,
    @SerialName("geoCoordinates") val geoCoordinates: NetworkGeoCoordinates? = null // Nullable
)

// Added extension function
fun NetworkAddress.asDomain(): Address = Address(
    locality = locality,
    country = country,
    region = region, // Nullable handled by domain model
    street = street, // Nullable handled by domain model
    postalCode = postalCode,
    geoCoordinates = geoCoordinates?.asDomain() // Handle nullable
) 