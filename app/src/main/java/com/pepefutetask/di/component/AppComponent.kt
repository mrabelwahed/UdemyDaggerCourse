package com.pepefutetask.di.component

import com.pepefutetask.di.module.*
import com.pepefutetask.di.scope.AppScope
import com.pepefutetask.ui.BaseFragment
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
    fun newPokemonLisComponent():PokemonListComponent
    fun newPokemonDetailsComponent():PokemonDetailsComponent
}