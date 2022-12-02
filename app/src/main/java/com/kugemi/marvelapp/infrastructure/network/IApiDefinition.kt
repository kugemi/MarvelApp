package com.kugemi.marvelapp.infrastructure.network

import com.kugemi.marvelapp.model.MarvelResponse
import com.kugemi.marvelapp.utils.NetworkUtils
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiDefinition {
    @GET("v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String = NetworkUtils.ts,
        @Query("apikey") apiKey: String = NetworkUtils.API_KEY,
        @Query("hash") hash: String = NetworkUtils.generateMd5Hash(),
        @Query("limit") limit: Int = 100,
    ): Deferred<MarvelResponse>
}