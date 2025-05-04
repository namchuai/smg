package com.example.network.model

import com.example.model.UrlData // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkUrlData(
    @SerialName("type") val type: String,
    @SerialName("url") val url: String? = null // Nullable
)

// Added extension function
fun NetworkUrlData.asDomain(): UrlData = UrlData(
    type = type,
    url = url // Nullable handled by domain model
) 