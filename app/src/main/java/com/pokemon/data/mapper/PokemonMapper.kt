package com.pokemon.data.mapper

import com.pokemon.data.entity.PokemonEntity
import com.pokemon.domain.model.Pokemon

object PokemonMapper {
    private fun transform(response : PokemonEntity): Pokemon {
        return Pokemon(response.name,response.url)
    }

    fun transform(responseCollection: Collection<PokemonEntity>): List<Pokemon> {
        val pokemonList = mutableListOf<Pokemon>()
        for (feedResponse in responseCollection) {
            val feed = transform(feedResponse)
                pokemonList.add(feed)
        }

        return pokemonList
    }
}