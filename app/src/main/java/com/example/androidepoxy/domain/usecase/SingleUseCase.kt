package com.example.androidepoxy.domain.usecase

import io.reactivex.rxjava3.core.Single

interface SingleUseCase<Type, in Params> {

    operator fun invoke(params: Params): Single<Type>

}