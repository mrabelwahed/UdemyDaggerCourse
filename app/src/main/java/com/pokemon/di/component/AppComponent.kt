package com.pokemon.di.component

import com.pokemon.di.module.*
import com.pokemon.di.scope.AppScope
import com.pokemon.di.subcomponent.PokemonDetailsComponent
import com.pokemon.di.subcomponent.PokemonListComponent
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        PokemonUsecaseModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {
    fun newPokemonLisComponent(): PokemonListComponent
    fun newPokemonDetailsComponent(): PokemonDetailsComponent
}