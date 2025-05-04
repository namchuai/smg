package com.example.domain

import com.example.data.RealEstateRepository

class BookmarkRealEstateUseCase(
    private val realEstateRepository: RealEstateRepository,
) {
    suspend operator fun invoke(
        realEstateId: String,
    ) = realEstateRepository.bookmarkRealEstate(realEstateId)
}