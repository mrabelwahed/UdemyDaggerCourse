package com.pepefutetask.di

import com.pepefutetask.ui.BaseActivity
import dagger.Component

@Component
interface BaseComponent {
 fun inject(baseActivity: BaseActivity)
}