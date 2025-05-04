package com.example.storage.di

import androidx.room.Room
import com.example.storage.SMGLocalDataSource
import com.example.storage.room.SMGDatabase
import com.example.storage.room.SMGRoomDatabase
import org.koin.dsl.module

private const val DATABASE_NAME = "smgdb"

val storageModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = SMGDatabase::class.java,
            name = DATABASE_NAME,
        ).build()
    }

    single {
        get<SMGDatabase>().bookmarkPropertyDao()
    }

    single<SMGLocalDataSource> {
        SMGRoomDatabase(get())
    }
}