package com.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pokemon.data.repository.PokemonDataRepository
import com.pokemon.domain.interactor.GetPokemonDetailsUseCase
import com.pokemon.ui.mapper.PokemonDetailsModelMapper
import com.pokemon.ui.viewstate.DataState

class PokemonDetailsViewModel : BaseViewModel() {
    var getPokemonDetailsUseCase : GetPokemonDetailsUseCase
    init {
        val repository = PokemonDataRepository()
        getPokemonDetailsUseCase = GetPokemonDetailsUseCase(repository)
    }
    private val viewState = MutableLiveData<DataState>()
    val livePokemonDetails: LiveData<DataState>
        get() = viewState

    fun getPokemonDetails(id: Int) {
        val disposable = getPokemonDetailsUseCase.execute(id)
            .subscribe({ res ->
                viewState.value = DataState.Success(PokemonDetailsModelMapper.transform(res))
            }, { error ->
                DataState.Error(error.message)
            })
        compositeDisposable.add(disposable)
    }

}