package com.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pokemon.data.repository.PokemonDataRepository
import com.pokemon.domain.interactor.GetPokemonListUseCase
import com.pokemon.ui.mapper.PokemonModelMapper
import com.pokemon.ui.viewstate.DataState
import io.reactivex.android.schedulers.AndroidSchedulers

class PokeMonListViewModel: BaseViewModel() {
    var getPokemonListUseCase: GetPokemonListUseCase

    init {
        val repository = PokemonDataRepository()
        getPokemonListUseCase = GetPokemonListUseCase(repository)
    }

    private var offset = 0
    private val viewState = MutableLiveData<DataState>()
    val livePokemonData: LiveData<DataState>
        get() = viewState


    fun initPagination() {
        val disposable = getPokemonListUseCase.execute(offset)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res ->
                    viewState.value = DataState.Success(PokemonModelMapper.transform(res))
                },
                { error -> viewState.value = DataState.Error(error.message) }
            )
        compositeDisposable.add(disposable)
    }

}