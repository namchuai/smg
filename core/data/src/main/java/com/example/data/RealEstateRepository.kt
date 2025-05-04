package com.example.data

import com.example.model.RealEstate
import kotlinx.coroutines.flow.Flow

interface RealEstateRepository {

    fun getProperties(): Flow<List<RealEstate>>

    suspend fun bookmarkRealEstate(id: String)

    suspend fun deleteBookmark(id: String)

    fun getBookmarkRealEstate(): Flow<List<String>>
}