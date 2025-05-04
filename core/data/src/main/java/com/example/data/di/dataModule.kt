package com.example.data.di

import com.example.data.RealEstateRepository
import com.example.data.RealEstateRepositoryImpl
import com.example.network.di.networkModule
import com.example.storage.di.storageModule
import org.koin.dsl.module

val dataModule = module {
    includes(networkModule, storageModule)
    single<RealEstateRepository> { RealEstateRepositoryImpl(get(), get()) }
}