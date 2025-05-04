package com.example.smgrealestate

import android.app.Application
import com.example.smgrealestate.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SMGApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SMGApplication)
            modules(appModule)
        }
    }
}