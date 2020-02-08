package com.pokemon.domain.interactor

import com.pokemon.data.entity.PokemonDetailsEntity
import com.pokemon.domain.model.PokemonDetails
import com.pokemon.domain.repository.PokemonRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetPokemonDetailsUseCase(private val pokemonRepository: PokemonRepository) :
    UseCase<Int, PokemonDetails> {
    override fun execute(param: Int): Flowable<PokemonDetails> {
        return pokemonRepository.getPokemonDetails(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}