package com.example.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RealEstateListResponse(
    @SerialName("from") val from: Int,
    @SerialName("size") val size: Int,
    @SerialName("total") val total: Int,
    @SerialName("results") val results: List<NetworkRealEstate>,
)