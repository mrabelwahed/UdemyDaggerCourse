package com.pokemon.data.entity

import com.pokemon.data.entity.PokemonEntity

data class PokemonResponse (
    val count:Int ,
    val next:String ,
    val previous:String?,
    val  results:ArrayList<PokemonEntity>)