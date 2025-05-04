package com.example.smgrealestate.di

import com.example.listing.di.listingModule
import org.koin.dsl.module

val appModule = module {
    includes(listingModule)
}