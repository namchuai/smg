package com.example.listing

import java.math.BigDecimal

data class RealEstateItem(
    val id: String,
    val title: String,
    val pricing: BigDecimal,
    val thumbnailUrls: List<String>,
    val bookmarked: Boolean,
)

data class RealEstateUiState(
    val realEstateList: List<RealEstateItem> = emptyList(),
    // TODO: namh handle the case loading, error and success
    // thinking of using async state
    val isLoading: Boolean = false,
    val error: String? = null,
)
