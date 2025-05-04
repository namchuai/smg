package com.example.domain

import com.example.data.RealEstateRepository

class DeleteBookmarkRealEstateUseCase(
    private val realEstateRepository: RealEstateRepository,
) {
    suspend operator fun invoke(
        realEstateId: String,
    ) = realEstateRepository.deleteBookmark(realEstateId)
}