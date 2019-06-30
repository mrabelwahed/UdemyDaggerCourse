package com.pepefutetask.di.component

import com.pepefutetask.di.module.PokemonListViewModelModule
import com.pepefutetask.di.module.PokemonUsecaseModule
import com.pepefutetask.di.module.RepositoryModule
import com.pepefutetask.di.module.ViewModelFactoryModule
import com.pepefutetask.di.scope.ActivityScope
import com.pepefutetask.ui.PokemonListFragment
import dagger.Component
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