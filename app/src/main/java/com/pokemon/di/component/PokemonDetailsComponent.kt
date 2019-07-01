package com.pokemon.di.component

import com.pokemon.di.module.PokemonDetailsViewModelModule
import com.pokemon.di.module.ViewModelFactoryModule
import com.pokemon.di.scope.FragmentScope
import com.pokemon.ui.PokemonDetailsFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonDetailsViewModelModule::class
    ]
)
interface PokemonDetailsComponent {
    fun inject(pokemonDetailsFragment: PokemonDetailsFragment)
}