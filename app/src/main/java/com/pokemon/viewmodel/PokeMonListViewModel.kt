package com.pokemon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pokemon.domain.PokemonUsecase
import com.pokemon.ui.viewstate.ServerDataState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import javax.inject.Inject

class PokeMonListViewModel @Inject constructor(private val usecase: PokemonUsecase) :
    BaseViewModel() {

    val paginator = PublishProcessor.create<Int>()
    private var offset = 0
    private val viewState = MutableLiveData<ServerDataState>()
    val livePokemonData: LiveData<ServerDataState>
        get() = viewState


    fun initPagination() {
        val disposable = paginator
            .doOnNext { viewState.value = ServerDataState.Loading }
            .concatMap { offset -> usecase.getPokemonList(offset) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { res -> viewState.value = ServerDataState.Success(res) },
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