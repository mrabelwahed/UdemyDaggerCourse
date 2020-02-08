package com.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pokemon.domain.interactor.GetPokemonDetailsUseCase
import com.pokemon.ui.mapper.PokemonDetailsModelMapper
import com.pokemon.ui.viewstate.ServerDataState
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase) :
    BaseViewModel() {

    private val viewState = MutableLiveData<ServerDataState>()
    val livePokemonDetails: LiveData<ServerDataState>
        get() = viewState

    fun getPokemonDetails(id: Int) {
        val disposable = getPokemonDetailsUseCase.execute(id)
            .subscribe({ res ->
                viewState.value = ServerDataState.Success(PokemonDetailsModelMapper.transform(res))
            }, { error ->
                ServerDataState.Error(error.message)
            })
        compositeDisposable.add(disposable)
    }

}