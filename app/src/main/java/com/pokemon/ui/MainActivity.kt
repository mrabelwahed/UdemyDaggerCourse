package com.pokemon.ui

import com.pokemon.R


class MainActivity : BaseActivity() {


    override fun getLayoutById() = R.layout.activity_main
    private val pokemonListFragment = PokemonListFragment()

    override fun initUI() {
        supportFragmentManager.beginTransaction().add(R.id.container, pokemonListFragment).commit()
    }
}
