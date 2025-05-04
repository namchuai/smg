package com.example.network

import com.example.network.model.NetworkRealEstate

interface SMGNetworkDataSource {

    suspend fun getRealEstateList(): List<NetworkRealEstate>
}