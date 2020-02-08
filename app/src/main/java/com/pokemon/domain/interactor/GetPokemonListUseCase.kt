package com.pokemon.domain.interactor

import com.pokemon.data.entity.PokemonResponse
import com.pokemon.domain.model.Pokemon
import com.pokemon.domain.repository.PokemonRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) :
    UseCase<Int, List<Pokemon>> {
    override fun execute(param: Int): Flowable<List<Pokemon>> {
        return pokemonRepository.getPokemonList(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}