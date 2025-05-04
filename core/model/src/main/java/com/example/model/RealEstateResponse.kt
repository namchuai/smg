package com.example.model

data class RealEstateResponse(
    val from: Int,
    val size: Int,
    val total: Int,
    val results: List<RealEstate>,
    val maxFrom: Int
) 