package com.pepefutetask.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pepefutetask.BaseApp
import com.pepefutetask.viewmodel.ViewModelFactory
import javax.inject.Inject

abstract  class BaseFragment : Fragment() {
    @Inject  lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutById(),container,false)
    }

    abstract  fun getLayoutById(): Int

}