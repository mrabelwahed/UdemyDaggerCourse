package com.pokemon.ui.mapper

import com.pokemon.data.entity.PokemonEntity
import com.pokemon.domain.model.Pokemon
import com.pokemon.ui.model.PokemonModel

object PokemonModelMapper {
    private fun transform(response : Pokemon): PokemonModel {
        return PokemonModel(response.name,response.url)
    }

    fun transform(responseCollection: Collection<Pokemon>): List<PokemonModel> {
        val pokemonList = mutableListOf<PokemonModel>()
        for (feedResponse in responseCollection) {
            val feed = transform(feedResponse)
            if (feed != null) {
                pokemonList.add(feed)
            }
        }

        return pokemonList
    }
}