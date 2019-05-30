package com.pepefutetask.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pepefutetask.POKEMON_DETAILS_KEY
import com.pepefutetask.R
import com.pepefutetask.viewmodel.PokeMonViewModel



class MainActivity : BaseActivity() {
    private lateinit var viewModel: PokeMonViewModel

    override fun getLayoutById() = R.layout.activity_main
    private val pokemonListFragment = PokemonListFragment()
    private val pokemonDetailsFragment = PokemonDetailsFragment()

    override fun initUI() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)[PokeMonViewModel::class.java]
        supportFragmentManager.beginTransaction().add(R.id.container, pokemonListFragment).commit()
    }

    fun observePokemonList() {
        viewModel.getLivePokemonList().observe(this, Observer {
            pokemonListFragment.setData(it)
        })
    }



    fun getPokemonList() {
        viewModel.getPokemonList()
    }

    fun getPokemonDetails(id: Int) {

        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY,id)
        pokemonDetailsFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()

    }

    fun  getViewModel() = viewModel



}
