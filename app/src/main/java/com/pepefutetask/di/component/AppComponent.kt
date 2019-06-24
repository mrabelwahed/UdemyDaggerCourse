package com.pepefutetask.di.component

import com.pepefutetask.di.module.NetworkModule
import com.pepefutetask.di.module.PokemonUsecaseModule
import com.pepefutetask.di.module.RepositoryModule
import com.pepefutetask.di.module.ViewModelModule
import com.pepefutetask.di.scope.AppScope
import com.pepefutetask.ui.BaseFragment
import dagger.Component

@AppScope
@Component(
    modules = [
        NetworkModule::class,
        PokemonUsecaseModule::class,
        ViewModelModule::class,
        RepositoryModule::class]
)
interface AppComponent {
    fun inject(baseFragment: BaseFragment)
}