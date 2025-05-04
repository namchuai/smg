package com.example.storage.room

import com.example.storage.SMGLocalDataSource
import com.example.storage.room.dao.BookmarkPropertyDao
import com.example.storage.room.entity.BookmarkProperty
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class SMGRoomDatabase(
    private val bookmarkPropertyDao: BookmarkPropertyDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) : SMGLocalDataSource {

    override suspend fun bookmarkProperty(property: BookmarkProperty) =
        withContext(dispatcher) { bookmarkPropertyDao.insert(property) }

    override fun getBookmarkProperty(): Flow<List<BookmarkProperty>> =
        bookmarkPropertyDao.getBookmarkProperties()

    override suspend fun deleteBookmarkProperty(property: BookmarkProperty) =
        withContext(dispatcher) { bookmarkPropertyDao.delete(property) }
}
