package com.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import com.pokemon.data.PokemonResponse
import com.pokemon.domain.PokemonUsecase
import com.pokemon.ui.viewstate.ServerDataState
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor(private val usecase: PokemonUsecase) : BaseViewModel() {
    private val viewState = MutableLiveData<ServerDataState>()

    fun getPokemonList() {
        if (viewState.value != null) {
            return
        }
        val disposable = usecase.getPokemonList(0)
            .subscribe ({res->
                viewState.value = ServerDataState.success(res)
            },{
                error->viewState.value = ServerDataState.error(error.message)
            })
        compositeDisposable.add(disposable)
    }

    fun getItems(offest : Int) = usecase.getPokemonList(offest)



    fun getLivePokemonList() = viewState


}