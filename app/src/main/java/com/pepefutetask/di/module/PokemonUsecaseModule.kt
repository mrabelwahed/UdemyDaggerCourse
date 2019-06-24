package com.pepefutetask.di.module

import com.pepefutetask.di.scope.AppScope
import com.pepefutetask.domain.PokemonUsecase
import com.pepefutetask.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonUsecaseModule {
    @AppScope
    @Provides
    fun provideFeedUseCase(repository :PokemonRepository) = PokemonUsecase(repository)
}