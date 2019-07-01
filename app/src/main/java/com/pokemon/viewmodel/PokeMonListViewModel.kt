package com.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pokemon.data.PokemonResponse
import com.pokemon.domain.PokemonUsecase
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor(private val usecase: PokemonUsecase) : BaseViewModel() {

    private val pokemonListMutableLiveData = MutableLiveData<PokemonResponse>()

    fun getPokemonList() {
        if (pokemonListMutableLiveData.value != null) {
            return
        }
        val disposable = usecase.getPokemonList(0)
            .subscribe {
                pokemonListMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }



    fun getLivePokemonList() = pokemonListMutableLiveData


}