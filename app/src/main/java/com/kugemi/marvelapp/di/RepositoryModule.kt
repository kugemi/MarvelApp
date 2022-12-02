package com.kugemi.marvelapp.di

import com.kugemi.marvelapp.infrastructure.network.IServerClient
import com.kugemi.marvelapp.infrastructure.network.implementation.ServerClient
import com.kugemi.marvelapp.infrastructure.repositories.implementation.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideCharactersRepository(serverClient: IServerClient) =
        CharactersRepository(serverClient)
}