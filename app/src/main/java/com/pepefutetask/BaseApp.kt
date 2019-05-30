package com.pepefutetask

import android.app.Application
import com.pepefutetask.di.BaseComponent
import com.pepefutetask.di.DaggerBaseComponent
import com.pepefutetask.di.module.NetworkModule
import com.pepefutetask.di.module.PokemonUsecaseModule
import com.pepefutetask.di.module.RepositoryModule

class BaseApp : Application() {
    lateinit var appComponent:BaseComponent

    override fun onCreate() {
        super.onCreate()
        this.appComponent = this.initDagger()
    }



    private fun initDagger()  = DaggerBaseComponent.builder()
        .networkModule(NetworkModule())
        .repositoryModule(RepositoryModule())
        .pokemonUsecaseModule(PokemonUsecaseModule())
        .build()
}