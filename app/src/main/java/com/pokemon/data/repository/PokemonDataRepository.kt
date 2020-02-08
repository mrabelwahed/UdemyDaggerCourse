package com.pokemon.data.repository

import com.pokemon.LIMIT
import com.pokemon.data.entity.PokemonDetailsEntity
import com.pokemon.data.entity.PokemonResponse
import com.pokemon.data.mapper.PokemonDetailsMapper
import com.pokemon.data.mapper.PokemonMapper
import com.pokemon.data.network.PokemonApi
import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.model.PokemonDetails
import com.pokemon.domain.repository.PokemonRepository
import io.reactivex.Flowable

class PokemonDataRepository (private val pokemonApi: PokemonApi) :
    PokemonRepository {

    override fun getPokemonList(offset:Int): Flowable<List<Pokemon>>{
        return  pokemonApi.getPokemonList(offset , LIMIT).map { res -> PokemonMapper.transform(res.results) }
    }

    override fun getPokemonDetails(id:Int): Flowable<PokemonDetails> {
        return pokemonApi.getPokemonDetails(id).map { res->PokemonDetailsMapper.transform(res) }
    }

}