package com.pepefutetask.di

import com.pepefutetask.di.module.NetworkModule
import com.pepefutetask.di.module.PokemonUsecaseModule
import com.pepefutetask.di.module.RepositoryModule
import com.pepefutetask.di.module.ViewModelModule
import com.pepefutetask.ui.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
 NetworkModule::class,
 ViewModelModule::class,
 PokemonUsecaseModule::class,
 RepositoryModule::class])
interface BaseComponent {
 fun inject(baseActivity: BaseActivity)
}