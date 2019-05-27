package com.pepefutetask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pepefutetask.R

class MainActivity : BaseActivity() {

    override fun getLayoutRes() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
