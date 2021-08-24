package com.pokemon.di

import com.pokemon.data.network.PokemonApi
import com.pokemon.data.repository.PokemonDataRepository
import com.pokemon.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokemonRepositoryModule {
    @Singleton
    @Provides
    fun providesPokemonRepository(pokemonApi : PokemonApi) : PokemonRepository{
       return PokemonDataRepository(pokemonApi)
    }
}