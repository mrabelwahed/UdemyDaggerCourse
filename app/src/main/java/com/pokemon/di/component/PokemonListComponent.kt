package com.pokemon.di.component

import com.pokemon.di.module.PokemonListViewModelModule
import com.pokemon.di.module.ViewModelFactoryModule
import com.pokemon.di.scope.ActivityScope
import com.pokemon.ui.PokemonListFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonListViewModelModule::class
    ]
)
interface PokemonListComponent {
    fun inject(pokemonListFragment: PokemonListFragment)
}