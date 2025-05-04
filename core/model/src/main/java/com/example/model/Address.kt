package com.example.model

data class Address(
    val locality: String,
    val country: String,
    val region: String?,
    val street: String?,
    val postalCode: String,
    val geoCoordinates: GeoCoordinates? = null // Make optional as it's not in listerBranding address
) 