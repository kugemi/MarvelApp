package com.kugemi.marvelapp.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kugemi.marvelapp.infrastructure.network.IApiDefinition
import com.kugemi.marvelapp.infrastructure.network.IServerClient
import com.kugemi.marvelapp.infrastructure.network.implementation.ServerClient
import com.kugemi.marvelapp.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun provideApiDefinition(): IApiDefinition {
        val gson = GsonBuilder().create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(NetworkUtils.BASE_URL)
            .build()
        return retrofit.create(IApiDefinition::class.java)
    }

    @Provides
    fun provideServerClient(apiDefinition: IApiDefinition): IServerClient =
        ServerClient(apiDefinition)
}