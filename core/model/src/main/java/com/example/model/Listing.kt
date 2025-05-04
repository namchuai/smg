package com.example.model

data class Listing(
    val id: String,
    val offerType: String,
    val categories: List<String>,
    val prices: Prices,
    val address: Address,
    val characteristics: Characteristics,
    val localization: Localization,
    val lister: Lister
) 