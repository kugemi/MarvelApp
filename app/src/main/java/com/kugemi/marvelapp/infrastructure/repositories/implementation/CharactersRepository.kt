package com.kugemi.marvelapp.infrastructure.repositories.implementation

import com.kugemi.marvelapp.infrastructure.network.IServerClient
import com.kugemi.marvelapp.infrastructure.network.implementation.ServerClient
import com.kugemi.marvelapp.infrastructure.repositories.ICharactersRepository
import com.kugemi.marvelapp.model.MarvelResponse

class CharactersRepository(private val serverClient: IServerClient) : ICharactersRepository {
    override suspend fun getCharacters(): MarvelResponse? {
        return serverClient.getCharacters()
    }
}