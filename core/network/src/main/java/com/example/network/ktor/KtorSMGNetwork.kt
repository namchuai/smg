package com.example.network.ktor

import com.example.network.SMGNetworkDataSource
import com.example.network.model.NetworkRealEstate
import com.example.network.model.RealEstateListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorSMGNetwork(
    private val smgClient: HttpClient,
) : SMGNetworkDataSource {
    override suspend fun getRealEstateList(): List<NetworkRealEstate> {
        return smgClient.get("properties").body<RealEstateListResponse>().results
    }
}