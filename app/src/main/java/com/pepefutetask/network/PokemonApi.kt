package com.pepefutetask.network

import com.pepefutetask.data.PokemonDetails
import com.pepefutetask.data.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {
    @GET("api/v2/pokemon")
    fun getPokemonList( @Query("offset") offset: Int, @Query("limit") limit: Int):
            Observable<PokemonResponse>

    @GET("api/v2/pokemon/{id}/")
    fun getPokemonDetails(@Path("id") id:Int) : Observable<PokemonDetails>

}