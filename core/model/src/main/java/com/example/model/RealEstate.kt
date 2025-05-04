package com.example.model

data class RealEstate(
    val id: String,
    val remoteViewing: Boolean,
    val listingType: ListingType,
    val listerBranding: ListerBranding?,
    val listing: Listing
)