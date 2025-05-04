package com.example.domain

import com.example.data.RealEstateRepository

class GetRealEstatesListUseCase(
    private val realEstateRepository: RealEstateRepository,
) {
    operator fun invoke() = realEstateRepository.getProperties()
}