package com.example.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.storage.room.dao.BookmarkPropertyDao
import com.example.storage.room.entity.BookmarkProperty

@Database(entities = [BookmarkProperty::class], version = 1)
abstract class SMGDatabase : RoomDatabase() {
    abstract fun bookmarkPropertyDao(): BookmarkPropertyDao
}
