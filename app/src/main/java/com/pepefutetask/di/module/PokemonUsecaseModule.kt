package com.pepefutetask.di.module

import com.pepefutetask.domain.PokemonUsecase
import com.pepefutetask.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonUsecaseModule {
    @Provides
    @Singleton
    fun provideFeedUseCase(repository :PokemonRepository) = PokemonUsecase(repository)
}