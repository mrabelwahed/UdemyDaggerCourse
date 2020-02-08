package com.pokemon.domain.interactor

import io.reactivex.Flowable

interface UseCase<P,R> {
    fun execute(param:P): Flowable<R>
}