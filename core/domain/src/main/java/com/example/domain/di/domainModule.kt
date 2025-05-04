package com.example.domain.di

import com.example.data.di.dataModule
import com.example.domain.BookmarkRealEstateUseCase
import com.example.domain.DeleteBookmarkRealEstateUseCase
import com.example.domain.GetBookmarkPropertiesUseCase
import com.example.domain.GetRealEstatesListUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    includes(dataModule)
    factoryOf(::GetRealEstatesListUseCase)
    factoryOf(::BookmarkRealEstateUseCase)
    factoryOf(::DeleteBookmarkRealEstateUseCase)
    factoryOf(::GetBookmarkPropertiesUseCase)
}