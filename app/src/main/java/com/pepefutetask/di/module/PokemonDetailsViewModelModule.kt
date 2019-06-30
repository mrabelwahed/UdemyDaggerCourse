package com.pepefutetask.di.module

import androidx.lifecycle.ViewModel
import com.pepefutetask.di.scope.ActivityScope
import com.pepefutetask.viewmodel.PokeMonListViewModel
import com.pepefutetask.viewmodel.PokemonDetailsViewModel
import com.pepefutetask.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class PokemonDetailsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PokemonDetailsViewModel::class)
    internal abstract fun bindPokemonDetailsViewModel(viewModel: PokemonDetailsViewModel): ViewModel
}