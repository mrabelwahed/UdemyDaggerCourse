package com.pokemon.network

import com.pokemon.data.PokemonDetails
import com.pokemon.data.PokemonResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {
    @GET("api/v2/pokemon")
    fun getPokemonList( @Query("offset") offset: Int, @Query("limit") limit: Int):
            Flowable<PokemonResponse>

    @GET("api/v2/pokemon/{id}/")
    fun getPokemonDetails(@Path("id") id:Int) : Flowable<PokemonDetails>

}