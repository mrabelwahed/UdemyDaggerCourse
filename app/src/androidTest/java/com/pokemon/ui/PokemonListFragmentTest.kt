package com.pokemon.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pokemon.R
import com.pokemon.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import viewassertion.RecyclerViewItemCountAssertion

@RunWith(AndroidJUnit4::class)
class PokemonListFragmentTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun onLaunchActivityPokemonListIsDisplayed() {
        onView(withId(R.id.pokemonList))
            .check(ViewAssertions.matches(isDisplayed()))
    }


    @Test
    fun shouldDisplayPokemonDetailsWhenPokemonListItemClicked() {
        onView(withId(R.id.pokemonList))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PokemonListAdapter.PokemonViewHolder>(
                    10,
                    click()
                )
            )
        onView(withId(R.id.detailsView))
            .check(ViewAssertions.matches(isDisplayed()))
    }


    @Test

    fun should_pokemon_list_contains_20_pokemons_at_first_page(){
        onView(withId(R.id.pokemonList))
            .check(RecyclerViewItemCountAssertion.hasItemCount(20))
    }

//    @Test
//    fun should_pokemonList_has_40_Items_after_first_Pagination(){
//
//        onView(withId(R.id.pokemonList))
//            .check(RecyclerViewItemCountAssertion.hasItemCount(20))
//
//        onView(withId(R.id.pokemonList))
//            .perform(RecyclerViewActions.scrollToPosition<PokemonListAdapter.PokemonViewHolder>(30))
//
//
//
//        onView(withId(R.id.pokemonList))
//            .check(RecyclerViewItemCountAssertion.hasItemCount(40))
//    }
}