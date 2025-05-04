package com.example.network.model

import com.example.model.Characteristics // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCharacteristics(
    @SerialName("numberOfRooms") val numberOfRooms: Double? = null, // Nullable
    @SerialName("livingSpace") val livingSpace: Int? = null, // Nullable
    @SerialName("lotSize") val lotSize: Int? = null, // Nullable
    @SerialName("totalFloorSpace") val totalFloorSpace: Int? = null // Nullable
)

// Added extension function
fun NetworkCharacteristics.asDomain(): Characteristics = Characteristics(
    numberOfRooms = numberOfRooms,
    livingSpace = livingSpace,
    lotSize = lotSize,
    totalFloorSpace = totalFloorSpace
) 