package com.example.model

data class ListerBranding(
    val logoUrl: String,
    val legalName: String,
    val name: String?,
    val address: Address?,
    val adActive: Boolean,
    val isQualityPartner: Boolean,
    val isPremiumBranding: Boolean,
    val profilePageUrlKeyword: String
) 