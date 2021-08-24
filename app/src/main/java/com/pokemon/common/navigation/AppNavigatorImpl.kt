package com.pokemon.common.navigation

import androidx.fragment.app.FragmentActivity
import com.pokemon.R
import com.pokemon.ui.PokemonDetailsFragment
import com.pokemon.ui.PokemonListFragment
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity): AppNavigator {
    override fun navigateTo(screen: Screen , pos:Int?) {
        val fragment = when(screen){
            Screen.POKEMON_LIST -> PokemonListFragment()
            Screen.POKEMON_DETAILS-> PokemonDetailsFragment.newInstance(pos)
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .addToBackStack(fragment.javaClass.canonicalName)
            .commit()

    }
}