package com.pepefutetask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pepefutetask.di.scope.ActivityScope
import com.pepefutetask.di.scope.AppScope
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@AppScope
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>,
        Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]?.get() as T
}