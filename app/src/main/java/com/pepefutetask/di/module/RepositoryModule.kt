package com.pepefutetask.di.module

import com.pepefutetask.di.scope.AppScope
import com.pepefutetask.network.PokemonApi
import com.pepefutetask.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @AppScope
    @Provides
    fun provideFeedRepository(api: PokemonApi) = PokemonRepository(api)
}