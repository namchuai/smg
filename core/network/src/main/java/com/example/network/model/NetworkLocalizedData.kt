package com.example.network.model

import com.example.model.LocalizedData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLocalizedData(
    @SerialName("attachments") val attachments: List<NetworkAttachment>,
    @SerialName("text") val text: NetworkTextData,
    @SerialName("urls") val urls: List<NetworkUrlData>
)

fun NetworkLocalizedData.asDomain(): LocalizedData = LocalizedData(
    attachments = attachments.map { it.asDomain() },
    text = text.asDomain(),
    urls = urls.map { it.asDomain() }
) 