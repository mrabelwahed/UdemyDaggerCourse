package com.pokemon.domain.model

import com.pokemon.data.entity.SpritesEntity
import java.io.Serializable

class PokemonDetails (val id: Int, val height:Int, val weight:Int, val sprites: SpritesEntity) :
    Serializable