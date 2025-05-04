package com.example.network.model

import com.example.model.GeoCoordinates // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkGeoCoordinates(
    @SerialName("latitude") val latitude: Double,
    @SerialName("longitude") val longitude: Double
)

// Added extension function
fun NetworkGeoCoordinates.asDomain(): GeoCoordinates = GeoCoordinates(
    latitude = latitude,
    longitude = longitude
) 