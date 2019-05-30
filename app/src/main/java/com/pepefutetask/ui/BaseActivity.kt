package com.pepefutetask.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pepefutetask.BaseApp
import com.pepefutetask.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract  class BaseActivity : AppCompatActivity() {
    @Inject  lateinit var viewModelFactory: ViewModelFactory

    abstract  fun getLayoutById(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutById())
        configureDagger()
        initUI()
    }

    abstract fun initUI()

    private  fun configureDagger() = (this.application as BaseApp).appComponent.inject(this)
}