package com.pokemon.ui

import com.pokemon.R
import com.pokemon.common.navigation.Screen


class MainActivity : BaseActivity() {
    override fun getLayoutById() = R.layout.activity_main
    override fun initUI() {
       appNavigator.navigateTo(Screen.POKEMON_LIST)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(supportFragmentManager.backStackEntryCount == 0)
            finish()
    }
}
