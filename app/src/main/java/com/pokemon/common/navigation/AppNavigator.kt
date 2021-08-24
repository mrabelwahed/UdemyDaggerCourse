package com.pokemon.common.navigation

interface AppNavigator {
    fun navigateTo(screen : Screen , pos: Int? = null)
}

enum class Screen{
    POKEMON_LIST, POKEMON_DETAILS
}