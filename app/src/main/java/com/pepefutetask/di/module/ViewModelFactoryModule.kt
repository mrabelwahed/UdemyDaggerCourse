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
abstract class ViewModelFactoryModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}