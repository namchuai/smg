package com.example.listing.di

import com.example.domain.di.domainModule
import com.example.listing.RealEstateListingViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val listingModule = module {
    includes(domainModule)
    viewModelOf(::RealEstateListingViewModel)
}