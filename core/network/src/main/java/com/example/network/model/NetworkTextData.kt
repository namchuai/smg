package com.example.network.model

import com.example.model.TextData // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkTextData(
    @SerialName("title") val title: String
)

// Added extension function
fun NetworkTextData.asDomain(): TextData = TextData(
    title = title
) 