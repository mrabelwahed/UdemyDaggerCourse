package com.pokemon.di.component

import com.pokemon.di.module.PokemonDetailsViewModelModule
import com.pokemon.di.module.ViewModelFactoryModule
import com.pokemon.di.scope.ActivityScope
import com.pokemon.ui.PokemonDetailsFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [
        ViewModelFactoryModule::class,
        PokemonDetailsViewModelModule::class
    ]
)
interface PokemonDetailsComponent {
    fun inject(pokemonDetailsFragment: PokemonDetailsFragment)
}