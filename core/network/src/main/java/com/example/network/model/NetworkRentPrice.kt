package com.example.network.model

import com.example.model.RentPrice // Import domain model
import kotlinx.serialization.Serializable

// Represents the potentially empty rent object {}
@Serializable
data class NetworkRentPrice(
    // Add fields here if the actual API response for rent includes them
    // Based on the example `rent: {}`, no fields are needed currently.
    // Using a placeholder or specific properties if known is better than Any.
    val placeholder: String? = null // Example placeholder if structure might exist but be empty
)

// Added extension function
// Mapper for RentPrice - needs more definition if rent object structure is complex
fun NetworkRentPrice.asDomain(): RentPrice = RentPrice(
    // Map fields if NetworkRentPrice has structure, otherwise return default/empty
    // Assuming placeholder mapping for now
    area = null, // Based on current definition
    price = null,
    interval = null
) 