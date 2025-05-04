package com.example.model

// Represents rental price information, fields are nullable as specifics are unknown from the example
data class RentPrice(
    val area: String? = null,
    val price: Long? = null,
    val interval: String? = null
) 