package com.pokemon.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pokemon.domain.interactor.GetPokemonListUseCase
import com.pokemon.ui.mapper.PokemonModelMapper
import com.pokemon.ui.viewstate.ServerDataState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase) :
    BaseViewModel() {

    val paginator = PublishProcessor.create<Int>()
    private var offset = 0
    private val viewState = MutableLiveData<ServerDataState>()
    val livePokemonData: LiveData<ServerDataState>
        get() = viewState


    fun initPagination() {
        val disposable = paginator
            .doOnNext { viewState.value = ServerDataState.Loading }
            .concatMap { offset -> getPokemonListUseCase.execute(offset) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res -> viewState.value = ServerDataState.Success(PokemonModelMapper.transform(res)) },
                { error -> viewState.value = ServerDataState.Error(error.message) }
            )

        compositeDisposable.add(disposable)
        paginator.onNext(offset)
    }


    fun nextPage(offset: Int) {
        this.offset = offset
        paginator.onNext(offset)
    }


}