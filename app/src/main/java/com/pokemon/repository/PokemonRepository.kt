package com.pokemon.repository

import com.pokemon.LIMIT
import com.pokemon.data.PokemonDetails
import com.pokemon.data.PokemonResponse
import com.pokemon.network.PokemonApi
import io.reactivex.Flowable
import io.reactivex.Observable

class PokemonRepository (val pokemonApi: PokemonApi){

    fun getPokemonList(offset:Int): Flowable<PokemonResponse>{
        return  pokemonApi.getPokemonList(offset , LIMIT)
    }

    fun getPokemonDetails(id:Int): Flowable<PokemonDetails> {
        return pokemonApi.getPokemonDetails(id)
    }

}