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

class PokemonListAdapter @Inject constructor() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val pokemonList = ArrayList<PokemonModel>()
    lateinit var listener: OnClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when(viewType){
            MAIN_ITEM -> {
                val view  =  LayoutInflater.from(parent.context).inflate(R.layout.item_list, null)
                return PokemonViewHolder(view) }
            LOADING_ITEM -> {
            val view  =  LayoutInflater.from(parent.context).inflate(R.layout.item_loading, null)
            return LoadingViewHolder(view) }

        }
       throw RuntimeException("not handled type")
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PokemonViewHolder){
            holder.pokemonName.text = pokemonList[position].name
            holder.pokemonName.setOnClickListener {
                listener.onClick(position, it)
            }
        }else if(holder is LoadingViewHolder){

        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (pokemonList[position].type == LOADING_ITEM)
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

    fun addPokmons(list: ArrayList<PokemonModel>) {
        pokemonList.addAll(list)
        notifyDataSetChanged()
    }

    fun addLoadingData(){
        pokemonList.add(
            PokemonModel(
                "loading",
                "fake",
                1
            )
        );
        notifyItemInserted(pokemonList.size - 1);
    }

    fun removeLoadingData(){
        pokemonList.remove(pokemonList[pokemonList.size - 1])
        notifyItemRemoved(pokemonList.size-1)
    }

    fun setClickListener(listener: OnClickListener) {
        this.listener = listener
    }

    companion object {
        const val MAIN_ITEM = 0
        const val LOADING_ITEM = 1
    }

}


