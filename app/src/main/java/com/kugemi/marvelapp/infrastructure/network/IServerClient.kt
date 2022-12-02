package com.kugemi.marvelapp.infrastructure.network

import com.kugemi.marvelapp.model.MarvelResponse

interface IServerClient {
    suspend fun getCharacters(): MarvelResponse?
}