package com.pokemon.ui.viewstate

import com.pokemon.data.PokemonResponse

sealed class ServerDataState {
    object loading : ServerDataState()
    object empty : ServerDataState()
    data class error(val message: String?) : ServerDataState()
    data class success<T>(val item: T) : ServerDataState()
}