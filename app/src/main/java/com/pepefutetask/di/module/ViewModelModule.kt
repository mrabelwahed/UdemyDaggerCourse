package com.pepefutetask.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pepefutetask.di.ViewModelKey
import com.pepefutetask.viewmodel.PokeMonViewModel
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
    @ViewModelKey(PokeMonViewModel::class)
    internal abstract fun postMainViewModel(viewModel: PokeMonViewModel): ViewModel

}