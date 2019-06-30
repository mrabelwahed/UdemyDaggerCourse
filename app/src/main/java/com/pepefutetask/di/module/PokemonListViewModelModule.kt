package com.pepefutetask.di.module

import androidx.lifecycle.ViewModel
import com.pepefutetask.di.scope.ActivityScope
import com.pepefutetask.viewmodel.PokeMonListViewModel
import com.pepefutetask.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class PokemonListViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PokeMonListViewModel::class)
    internal abstract fun bindPokemonListViewModel(viewModel: PokeMonListViewModel): ViewModel
}