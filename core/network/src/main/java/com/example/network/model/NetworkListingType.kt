package com.example.network.model

import com.example.model.ListingType // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkListingType(
    @SerialName("type") val type: String
)

// Added extension function
fun NetworkListingType.asDomain(): ListingType = ListingType(
    type = type
) 