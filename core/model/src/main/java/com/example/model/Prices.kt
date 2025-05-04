package com.example.model

data class Prices(
    val currency: String,
    val buy: BuyPrice?,
    val rent: RentPrice?
) 