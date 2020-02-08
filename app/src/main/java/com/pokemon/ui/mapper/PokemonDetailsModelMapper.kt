package com.pokemon.ui.mapper

import com.pokemon.data.entity.PokemonDetailsEntity
import com.pokemon.domain.model.PokemonDetails
import com.pokemon.ui.model.PokemonDetailsModel

object PokemonDetailsModelMapper {
    fun transform(response : PokemonDetails): PokemonDetailsModel {
        return PokemonDetailsModel(response.id,response.height,response.weight,response.sprites)
    }
}