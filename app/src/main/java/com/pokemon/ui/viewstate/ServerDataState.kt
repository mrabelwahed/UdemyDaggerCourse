package com.pokemon.ui.viewstate

sealed class ServerData {
    object loading : ServerData()
    object empty : ServerData()
    data class error(val message: String?) : ServerData()
    data class success<T>(val item: T) : ServerData()
}