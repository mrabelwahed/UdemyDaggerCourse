package com.pokemon.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.R
import com.pokemon.data.entity.PokemonEntity
import com.pokemon.domain.model.Pokemon
import com.pokemon.ui.model.PokemonModel
import kotlinx.android.synthetic.main.item_list.view.*
import kotlinx.android.synthetic.main.item_loading.view.*
import javax.inject.Inject

class PokemonListAdapter  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pokemonList = ArrayList<PokemonModel>()
    lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val view  =  LayoutInflater.from(parent.context).inflate(R.layout.item_list, null)
            return PokemonViewHolder(view)
    }
    override fun getItemCount() = pokemonList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonViewHolder){
            holder.pokemonName.text = pokemonList[position].name
            holder.pokemonName.setOnClickListener {
                listener.onClick(position, it)
            }
        }
    }
    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokemonName: TextView = view.pokemonName
    }
    fun addPokmons(list: ArrayList<PokemonModel>) {
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }
    fun setClickListener(listener: OnClickListener) {
        this.listener = listener
    }

}




