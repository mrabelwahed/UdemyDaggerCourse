package com.pokemon.ui.model

import com.pokemon.data.entity.SpritesEntity
import java.io.Serializable

class PokemonDetailsModel (val id: Int, val height:Int, val weight:Int, val sprites: SpritesEntity) :
    Serializable