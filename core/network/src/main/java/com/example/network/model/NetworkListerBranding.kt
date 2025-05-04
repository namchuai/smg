package com.example.network.model

import com.example.model.ListerBranding
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkListerBranding(
    @SerialName("logoUrl") val logoUrl: String,
    @SerialName("legalName") val legalName: String,
    @SerialName("name") val name: String? = null, // Nullable
    @SerialName("address") val address: NetworkAddress? = null, // Nullable
    @SerialName("adActive") val adActive: Boolean,
    @SerialName("isQualityPartner") val isQualityPartner: Boolean,
    @SerialName("isPremiumBranding") val isPremiumBranding: Boolean,
    @SerialName("profilePageUrlKeyword") val profilePageUrlKeyword: String
)

// Added extension function
fun NetworkListerBranding.asDomain(): ListerBranding = ListerBranding(
    logoUrl = logoUrl,
    legalName = legalName,
    name = name, // Nullable handled by domain model
    address = address?.asDomain(), // Handle nullable
    adActive = adActive,
    isQualityPartner = isQualityPartner,
    isPremiumBranding = isPremiumBranding,
    profilePageUrlKeyword = profilePageUrlKeyword
) 