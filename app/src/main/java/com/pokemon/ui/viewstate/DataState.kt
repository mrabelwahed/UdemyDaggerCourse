package com.pokemon.ui.viewstate

sealed class DataState {
    data class Error(val message: String?) : DataState()
    data class Success<T>(val item: T) : DataState()
}