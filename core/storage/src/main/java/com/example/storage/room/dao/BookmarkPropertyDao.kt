package com.example.storage.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.storage.room.entity.BookmarkProperty
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkPropertyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(property: BookmarkProperty)

    @Delete
    fun delete(property: BookmarkProperty)

    @Query("SELECT * FROM BookmarkProperty")
    fun getBookmarkProperties(): Flow<List<BookmarkProperty>>
}