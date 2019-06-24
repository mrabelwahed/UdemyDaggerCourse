package com.pepefutetask

import android.app.Application
import com.pepefutetask.di.component.AppComponent
import com.pepefutetask.di.component.DaggerAppComponent
import com.pepefutetask.di.module.NetworkModule
import com.pepefutetask.di.module.PokemonUsecaseModule
import com.pepefutetask.di.module.RepositoryModule

class BaseApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }

    private fun initDagger()  = DaggerAppComponent.builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .pokemonUsecaseModule(PokemonUsecaseModule())
        .build()

}