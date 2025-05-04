package com.example.network.model

import com.example.model.Lister // Import domain model
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents the Lister object, which can be empty {} or contain fields
@Serializable
data class NetworkLister(
    @SerialName("phone") val phone: String? = null, // Nullable
    @SerialName("logoUrl") val logoUrl: String? = null // Nullable
)

// Added extension function
fun NetworkLister.asDomain(): Lister = Lister(
    phone = phone, // Nullable handled by domain model
    logoUrl = logoUrl // Nullable handled by domain model
) 