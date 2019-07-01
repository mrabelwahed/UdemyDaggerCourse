package com.pokemon.di.module

import androidx.lifecycle.ViewModel
import com.pokemon.viewmodel.PokemonDetailsViewModel
import com.pokemon.viewmodel.ViewModelKey
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