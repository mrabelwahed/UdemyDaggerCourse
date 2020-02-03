package com.pokemon.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.R
import com.pokemon.data.Pokemon
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_loading.view.*
import javax.inject.Inject

class PokemonListAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pokemonList = ArrayList<Pokemon>()
    lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = if (viewType == MAIN_ITEM)
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, null)
        else
            LayoutInflater.from(parent.context).inflate(R.layout.item_loading, null)

        return PokemonViewHolder(view)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonViewHolder){
            holder.pokemonName.text = pokemonList.get(position).name
            holder.pokemonName.setOnClickListener {
                listener.onClick(position, it)
            }
        }else if(holder is LoadingViewHolder){

        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (pokemonList[position] == null)
            LOADING_ITEM
        else
            MAIN_ITEM
    }

    //main item
    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.pokemonName
    }

    //loading item
    class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val progressBar:ProgressBar = view.progressBar
    }

    fun addPokmons(list: ArrayList<Pokemon>) {
        pokemonList.clear()
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }

    fun setClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    companion object {
        const val MAIN_ITEM = 0
        const val LOADING_ITEM = 1
    }

}


