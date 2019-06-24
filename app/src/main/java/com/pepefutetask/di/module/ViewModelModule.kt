package com.pepefutetask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pepefutetask.viewmodel.ViewModelKey
import com.pepefutetask.viewmodel.PokeMonListViewModel
import com.pepefutetask.viewmodel.PokemonDetailsViewModel
import com.pepefutetask.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PokeMonListViewModel::class)
    internal abstract fun bindPokemonListViewModel(viewModel: PokeMonListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    internal abstract fun bindPokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel

}