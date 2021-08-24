package com.pokemon.di

import com.pokemon.common.navigation.AppNavigator
import com.pokemon.common.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract  class NavigationModule {
    @Binds
    abstract  fun bindsAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}