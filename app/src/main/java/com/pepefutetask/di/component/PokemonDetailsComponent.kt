package com.pepefutetask.di.component

import com.pepefutetask.di.module.PokemonDetailsViewModelModule
import com.pepefutetask.di.module.ViewModelFactoryModule
import com.pepefutetask.di.scope.ActivityScope
import com.pepefutetask.ui.PokemonDetailsFragment
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