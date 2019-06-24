package com.pepefutetask.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pepefutetask.POKEMON_DETAILS_KEY
import com.pepefutetask.R
import com.pepefutetask.viewmodel.PokeMonListViewModel



class MainActivity : BaseActivity() {


    override fun getLayoutById() = R.layout.activity_main
    private val pokemonListFragment = PokemonListFragment()

    override fun initUI() {
      //  viewModel = ViewModelProviders.of(this, viewModelFactory)[PokeMonListViewModel::class.java]
        supportFragmentManager.beginTransaction().add(R.id.container, pokemonListFragment).commit()
    }

//    fun observePokemonList() {
//        viewModel.getLivePokemonList().observe(this, Observer {
//            pokemonListFragment.setData(it)
//        })
//    }


//
//    fun getPokemonListData() {
//        viewModel.getPokemonListData()
//    }
//
//    fun getPokemonDetails(id: Int) {
//
//        val bundle = Bundle()
//        bundle.putInt(POKEMON_DETAILS_KEY,id)
//        pokemonDetailsFragment.arguments = bundle
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, pokemonDetailsFragment)
//            .addToBackStack(null)
//            .commit()
//
//    }
//
//    fun  getPokemonListViewModel() = viewModel



}
