package com.pokemon.di.module

import com.pokemon.di.scope.AppScope
import com.pokemon.data.repository.PokemonDataRepository
import com.pokemon.domain.interactor.GetPokemonDetailsUseCase
import com.pokemon.domain.interactor.GetPokemonListUseCase
import dagger.Module
import dagger.Provides

@Module
class PokemonUsecaseModule {
    @AppScope
    @Provides
    fun providePokemonListCase(repository : PokemonDataRepository) =
        GetPokemonListUseCase(repository)

    @AppScope
    @Provides
    fun providePokemonDetailsUseCase(repository : PokemonDataRepository) =
        GetPokemonDetailsUseCase(repository)
}