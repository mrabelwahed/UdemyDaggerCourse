package com.pokemon.domain.repository

import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.model.PokemonDetails
import io.reactivex.Flowable

interface PokemonRepository {
    fun getPokemonList(offset: Int): Flowable<List<Pokemon>>
    fun getPokemonDetails(id: Int): Flowable<PokemonDetails>
}