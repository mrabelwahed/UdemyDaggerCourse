package com.pokemon.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pokemon.R
import com.pokemon.ui.model.PokemonDetailsModel
import com.pokemon.ui.viewmodel.PokemonDetailsViewModel
import com.pokemon.ui.viewstate.DataState
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_pokemon_details.*


class PokemonDetailsFragment : BaseFragment() {
    private val  pokemonDetailsViewModel: PokemonDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getInt(POKEMON_POS)
        id?.let { getPokemonDetails(it) }
    }


    fun getPokemonDetails(id: Int) {
        if (isVisible) {
            pokemonDetailsViewModel.getPokemonDetails(id)
            observePokemonDetails()
        }

    }

    fun observePokemonDetails() {
        pokemonDetailsViewModel.livePokemonDetails.observe(viewLifecycleOwner, Observer {
            when (it) {
                is DataState.Success<*> -> setData(it.item as PokemonDetailsModel)
                is DataState.Error -> setError(it.message)
            }
        })
    }

    private fun setError(message: String?) {
        Log.e("Details-error", message)
    }

    fun setData(response: PokemonDetailsModel?) {
        Picasso.get().load(response?.sprites?.front_default).into(pokemonImage)
        pokemonWeight.text = "Weight is :".plus(response?.weight.toString())
        pokemonHeight.text = "Height is :".plus(response?.height.toString())
    }

    override fun getLayoutById() = R.layout.fragment_pokemon_details

    companion object{
        @JvmStatic
        fun newInstance(pos:Int?) : PokemonDetailsFragment{
            return PokemonDetailsFragment().apply {
                arguments = Bundle().apply {
                    if (pos != null) {
                        putInt(POKEMON_POS , pos)
                    }
                }
            }
        }
        const val POKEMON_POS = "pokemon_pos"
    }
}