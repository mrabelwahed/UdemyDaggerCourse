package com.pokemon.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pokemon.POKEMON_DETAILS_KEY
import com.pokemon.R
import com.pokemon.ui.model.PokemonModel
import com.pokemon.ui.viewmodel.PokeMonListViewModel
import com.pokemon.ui.viewstate.DataState
import kotlinx.android.synthetic.main.fragment_pokemon_list.*


class PokemonListFragment : BaseFragment(), OnClickListener {
    private val pokemonDetailsFragment = PokemonDetailsFragment()
    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var pokemonListAdapter: PokemonListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pokeMonListViewModel = ViewModelProvider(this).get(PokeMonListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun setupView() {
        pokemonListAdapter = PokemonListAdapter()
        linearLayoutManager = LinearLayoutManager(context)
        pokemonListAdapter.setClickListener(this)
        pokemonList.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = pokemonListAdapter
        }

    }

    private fun setData(response: ArrayList<PokemonModel>) {
        pokemonListAdapter.addPokmons(response)
    }


    override fun onClick(position: Int, view: View) {
        getPokemonDetails(position + 1)
    }

    private fun observePokemonList() {
        pokeMonListViewModel.livePokemonData.observe(this, Observer {
            when (it) {
                is DataState.Success<*> -> {
                    setData(it.item as ArrayList<PokemonModel>)
                }
                is DataState.Error -> {
                    setError(it.message)
                }
            }
        })
    }

    private fun setError(message: String?) {
        message?.let {
            Toast.makeText(activity, "something went wrong because of $message", Toast.LENGTH_SHORT).show()
        }
    }


    override fun getLayoutById(): Int {
        return R.layout.fragment_pokemon_list
    }

    private fun initUI() {
        setupView()
        pokeMonListViewModel.initPagination()
        observePokemonList()
    }




    private fun getPokemonDetails(id: Int) {
        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY, id)
        pokemonDetailsFragment.arguments = bundle

        (activity as BaseActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()

    }
}
