package com.pokemon.di.module

import com.pokemon.di.scope.AppScope
import com.pokemon.network.PokemonApi
import com.pokemon.repository.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonApi) = PokemonRepository(api)
}