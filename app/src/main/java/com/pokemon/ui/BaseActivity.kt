package com.pokemon.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract  class BaseActivity : AppCompatActivity() {
    abstract  fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        initUI()
    }


    abstract fun initUI()

}