package com.pokemon.di.module

import com.pokemon.di.scope.AppScope
import com.pokemon.data.network.PokemonApi
import com.pokemon.data.repository.PokemonDataRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonApi) =
        PokemonDataRepository(api)
}