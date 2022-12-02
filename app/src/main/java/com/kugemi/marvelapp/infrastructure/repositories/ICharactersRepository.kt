package com.kugemi.marvelapp.infrastructure.repositories

import com.kugemi.marvelapp.model.MarvelResponse

interface ICharactersRepository {
    suspend fun getCharacters(): MarvelResponse?
}