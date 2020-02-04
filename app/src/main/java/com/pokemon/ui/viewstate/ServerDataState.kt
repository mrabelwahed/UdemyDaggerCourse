package com.pokemon.ui.viewstate

sealed class ServerDataState {
    object Loading : ServerDataState()
    data class Error(val message: String?) : ServerDataState()
    data class Success<T>(val item: T) : ServerDataState()
}