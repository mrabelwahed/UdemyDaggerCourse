package com.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pokemon.domain.PokemonUsecase
import com.pokemon.ui.viewstate.ServerDataState
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(private val usecase: PokemonUsecase)  : BaseViewModel() {

    private val viewState  = MutableLiveData<ServerDataState>()

    fun getPokemonDetails(id:Int) {
        val disposable = usecase.getPokemonDetails(id)
            .subscribe ({ res->
                viewState.value = ServerDataState.Success(res)
            },{
                error -> ServerDataState.Error(error.message)
            })
        compositeDisposable.add(disposable)
    }

    fun getLivePokemonDetails() = viewState
}