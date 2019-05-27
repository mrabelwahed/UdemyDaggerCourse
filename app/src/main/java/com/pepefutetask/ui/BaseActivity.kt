package com.pepefutetask.ui

import androidx.appcompat.app.AppCompatActivity

abstract  class BaseActivity : AppCompatActivity() {
    abstract  fun getLayoutRes(): Int
}