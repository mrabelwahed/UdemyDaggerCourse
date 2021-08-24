package com.pokemon.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pokemon.common.navigation.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract  class BaseActivity : AppCompatActivity() {
    @Inject lateinit var appNavigator: AppNavigator

    abstract  fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        initUI()
    }


    abstract fun initUI()

}