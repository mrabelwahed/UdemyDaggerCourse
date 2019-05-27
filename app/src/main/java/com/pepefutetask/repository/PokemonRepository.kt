package com.pepefutetask.repository

import com.pepefutetask.data.PokemonDetails
import com.pepefutetask.data.PokemonResponse
import com.pepefutetask.network.PokemonApi
import io.reactivex.Observable

class PokemonRepository (val pokemonApi: PokemonApi){

    fun getPokemonList(offset:Int): Observable<PokemonResponse>{
        return  Observable.empty()
    }

    fun getPokemonDetails(id:Int):Observable<PokemonDetails>{
        return Observable.empty()
    }

}