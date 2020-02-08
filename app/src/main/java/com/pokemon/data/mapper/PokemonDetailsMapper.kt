package com.pokemon.data.mapper

import com.pokemon.data.entity.PokemonDetailsEntity
import com.pokemon.domain.model.PokemonDetails

object PokemonDetailsMapper {
    fun transform(response : PokemonDetailsEntity): PokemonDetails {
        return PokemonDetails(response.id,response.height,response.weight,response.sprites)
    }
}