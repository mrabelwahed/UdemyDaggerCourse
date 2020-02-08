package com.pokemon.data.network

import com.pokemon.data.entity.PokemonDetailsEntity
import com.pokemon.data.entity.PokemonResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {
    @GET("api/v2/pokemon")
    fun getPokemonList( @Query("offset") offset: Int, @Query("limit") limit: Int):
            Flowable<PokemonResponse>

    @GET("api/v2/pokemon/{id}/")
    fun getPokemonDetails(@Path("id") id:Int) : Flowable<PokemonDetailsEntity>

}