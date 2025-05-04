package com.example.data

import com.example.model.RealEstate
import com.example.network.SMGNetworkDataSource
import com.example.network.model.asDomain
import com.example.storage.SMGLocalDataSource
import com.example.storage.room.entity.BookmarkProperty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class RealEstateRepositoryImpl(
    private val smgNetworkDataSource: SMGNetworkDataSource,
    private val smgLocalDataSource: SMGLocalDataSource,
) : RealEstateRepository {

    override fun getProperties(): Flow<List<RealEstate>> {
        return flow {
            val data = smgNetworkDataSource.getRealEstateList().map { networkRealEstate ->
                networkRealEstate.asDomain()
            }
            emit(data)
        }

    }

    override suspend fun bookmarkRealEstate(id: String) {
        smgLocalDataSource.bookmarkProperty(BookmarkProperty(id))
    }

    override suspend fun deleteBookmark(id: String) {
        smgLocalDataSource.deleteBookmarkProperty(BookmarkProperty(id))
    }

    override fun getBookmarkRealEstate(): Flow<List<String>> {
        return smgLocalDataSource.getBookmarkProperty().map { bookmarkPropertyList ->
            bookmarkPropertyList.map { bookmarkProperty ->
                bookmarkProperty.id
            }
        }
    }
}