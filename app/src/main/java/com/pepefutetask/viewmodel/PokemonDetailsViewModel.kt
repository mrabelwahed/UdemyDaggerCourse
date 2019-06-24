package com.pepefutetask.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pepefutetask.data.PokemonDetails
import com.pepefutetask.domain.PokemonUsecase
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(private val usecase: PokemonUsecase)  : BaseViewModel() {

    private val pokemonDetailsMutableLiveData  = MutableLiveData<PokemonDetails>()

    fun getPokemonDetails(id:Int) {
        val disposable = usecase.getPokemonDetails(id)
            .subscribe {
                pokemonDetailsMutableLiveData.value = it
            }
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonDetails() = pokemonDetailsMutableLiveData
}