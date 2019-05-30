package com.pepefutetask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pepefutetask.POKEMON_DETAILS_KEY
import com.pepefutetask.R
import com.pepefutetask.data.PokemonDetails
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_details.*

class PokemonDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt(POKEMON_DETAILS_KEY)
        id?.let {  getPokemonDetails(it) }
    }

    fun getPokemonDetails(id: Int) {
        if (isVisible) {
            (activity as MainActivity).getViewModel().getPokemonDetails(id)
            observePokemonDetails()
        }

    }

    fun observePokemonDetails() {
        (activity as MainActivity).getViewModel().getLivePokemonDetails().observe(this, Observer {
            setData(it)
        })
    }

    fun setData(response: PokemonDetails?) {
            Picasso.get().load(response?.sprites?.front_default).into(pokemonImage)
            pokemonWeight.text = "Weight is :".plus(response?.weight.toString())
            pokemonHeight.text = "Height is :".plus(response?.height.toString())
    }
}