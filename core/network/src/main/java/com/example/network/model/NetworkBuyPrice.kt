package com.example.network.model

import com.example.model.BuyPrice // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkBuyPrice(
    @SerialName("area") val area: String? = null, // Nullable
    @SerialName("price") val price: Long,
    @SerialName("interval") val interval: String? = null // Nullable
)

// Added extension function
fun NetworkBuyPrice.asDomain(): BuyPrice = BuyPrice(
    area = area, // Nullable handled by domain model
    price = price,
    interval = interval // Nullable handled by domain model
) 