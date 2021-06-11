package com.pokemon.data.entity


data class PokemonResponse (
    val count:Int ,
    val next:String ,
    val previous:String?,
    val  results:ArrayList<PokemonEntity>)