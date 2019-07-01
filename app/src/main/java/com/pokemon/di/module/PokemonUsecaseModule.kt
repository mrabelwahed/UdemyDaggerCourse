package com.pokemon.di.module

import com.pokemon.di.scope.AppScope
import com.pokemon.domain.PokemonUsecase
import com.pokemon.repository.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class PokemonUsecaseModule {
    @AppScope
    @Provides
    fun provideFeedUseCase(repository :PokemonRepository) = PokemonUsecase(repository)
}