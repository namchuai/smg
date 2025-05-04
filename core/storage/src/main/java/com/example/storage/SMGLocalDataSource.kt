package com.example.storage

import com.example.storage.room.entity.BookmarkProperty
import kotlinx.coroutines.flow.Flow

interface SMGLocalDataSource {

    suspend fun bookmarkProperty(property: BookmarkProperty)

    fun getBookmarkProperty(): Flow<List<BookmarkProperty>>

    suspend fun deleteBookmarkProperty(property: BookmarkProperty)
}