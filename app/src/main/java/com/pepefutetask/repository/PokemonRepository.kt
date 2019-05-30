package com.pepefutetask.repository

import com.pepefutetask.LIMIT
import com.pepefutetask.data.PokemonDetails
import com.pepefutetask.data.PokemonResponse
import com.pepefutetask.network.PokemonApi
import io.reactivex.Observable

class PokemonRepository (val pokemonApi: PokemonApi){

    fun getPokemonList(offset:Int): Observable<PokemonResponse>{
        return  pokemonApi.getPokemonList(offset , LIMIT)
    }

    fun getPokemonDetails(id:Int):Observable<PokemonDetails>{
        return pokemonApi.getPokemonDetails(id)
    }

}