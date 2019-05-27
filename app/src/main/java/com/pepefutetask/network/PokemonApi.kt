package com.pepefutetask.network

import com.pepefutetask.data.PokemonResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface PokemonApi {
    @GET("api/v2/pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int):
            Observable<PokemonResponse>
}