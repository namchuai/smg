package com.example.domain

import com.example.data.RealEstateRepository

class GetBookmarkPropertiesUseCase(
    private val realEstateRepository: RealEstateRepository,
) {
    operator fun invoke() = realEstateRepository.getBookmarkRealEstate()
}