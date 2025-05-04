package com.example.network.model

import com.example.model.Attachment // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAttachment(
    @SerialName("type") val type: String,
    @SerialName("url") val url: String,
    @SerialName("file") val file: String
)

// Added extension function
fun NetworkAttachment.asDomain(): Attachment = Attachment(
    type = type,
    url = url,
    file = file
) 