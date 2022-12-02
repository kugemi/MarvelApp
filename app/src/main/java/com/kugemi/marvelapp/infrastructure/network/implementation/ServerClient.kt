package com.kugemi.marvelapp.infrastructure.network.implementation

import com.kugemi.marvelapp.infrastructure.network.IApiDefinition
import com.kugemi.marvelapp.infrastructure.network.IServerClient
import com.kugemi.marvelapp.model.MarvelResponse
import retrofit2.HttpException

class ServerClient(private val apiDefinition: IApiDefinition) : IServerClient {
    override suspend fun getCharacters(): MarvelResponse? {
        return try {
            val serverResult = apiDefinition.getCharacters().await()
            MarvelResponse(
                attributionHTML = serverResult.attributionHTML,
                attributionText = serverResult.attributionText,
                code = serverResult.code,
                copyright = serverResult.copyright,
                data = serverResult.data,
                etag = serverResult.etag,
                status = serverResult.status
            )
        } catch (exception : HttpException) {
            null
        }
    }

}