package com.pokemon.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pokemon.BaseApp
import com.pokemon.POKEMON_DETAILS_KEY
import com.pokemon.R
import com.pokemon.data.PokemonResponse
import com.pokemon.viewmodel.PokeMonListViewModel
import com.pokemon.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import javax.inject.Inject

class PokemonListFragment : BaseFragment(), OnClickListener {
    private val pokemonDetailsFragment = PokemonDetailsFragment()

    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    val pokadapter = PokemonListAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ( activity?.applicationContext as BaseApp).appComponent
            .newPokemonLisComponent().inject(this)
        pokeMonListViewModel = ViewModelProviders.of(this,viewModelFactory)[PokeMonListViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
    }

    fun setupView(view: View) {
        val linearLayoutManager = LinearLayoutManager(context)
        pokadapter.setClickListener(this)
        pokemonList.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = pokadapter
        }

    }

    fun getPokemonListData() {
        pokeMonListViewModel.getPokemonList()
        observePokemonList()
    }

    fun setData(response: PokemonResponse?) {
        response?.results?.let { pokadapter.addPokmons(it) }
    }



    override fun onClick(position: Int, view: View) {

        getPokemonDetails(position+1)
    }

    fun observePokemonList() {
        pokeMonListViewModel.getLivePokemonList().observe(this, Observer {
            setData(it)
        })
    }


    override fun getLayoutById(): Int {
        return R.layout.fragment_pokemon_list
    }

     fun initUI(view: View) {
        setupView(view)
        getPokemonListData()
    }


    fun getPokemonDetails(id: Int) {
        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY,id)
        pokemonDetailsFragment.arguments = bundle

        (activity as BaseActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()

    }
}
