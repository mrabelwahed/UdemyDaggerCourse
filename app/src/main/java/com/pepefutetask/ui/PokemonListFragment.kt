package com.pepefutetask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.pepefutetask.R
import com.pepefutetask.data.PokemonResponse
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

class PokemonListFragment : Fragment() , OnClickListener{
    override fun onClick(position: Int, view: View) {

        getPokemonDetails(position+1)
    }

    val pokadapter = PokemonListAdapter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        getPokemonList()
    }

     fun initUI(view : View){
        val linearLayoutManager = LinearLayoutManager(context)
         pokadapter.setClickListener(this)
         pokemonList.apply {
             layoutManager = linearLayoutManager
             addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
             adapter = pokadapter
         }

    }

    fun getPokemonList(){
        (activity as MainActivity).getPokemonList()
        (activity as MainActivity).observePokemonList()
    }

    fun setData(response: PokemonResponse?) {
        response?.results?.let {  pokadapter.addPokmons(it) }
    }

    fun getPokemonDetails(position:Int){
        (activity as MainActivity).getPokemonDetails(position)
        //(activity as MainActivity).observePokemonDetails()
    }


}
