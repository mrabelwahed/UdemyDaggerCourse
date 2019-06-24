package com.pepefutetask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pepefutetask.BaseApp
import com.pepefutetask.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract  class BaseActivity : AppCompatActivity() {
    abstract  fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        initUI()
    }


    abstract fun initUI()

}