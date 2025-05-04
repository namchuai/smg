package com.example.network.model

import com.example.model.Prices
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPrices(
    @SerialName("currency") val currency: String,
    @SerialName("buy") val buy: NetworkBuyPrice? = null, // Nullable
    @SerialName("rent") val rent: NetworkRentPrice? = null // Nullable
)

// Added extension function
fun NetworkPrices.asDomain(): Prices = Prices(
    currency = currency,
    buy = buy?.asDomain(), // Handle nullable
    rent = rent?.asDomain() // Handle nullable
) 