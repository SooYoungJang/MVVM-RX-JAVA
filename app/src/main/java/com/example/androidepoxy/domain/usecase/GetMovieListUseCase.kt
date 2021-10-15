package com.example.androidepoxy.domain.usecase

import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.repository.NaverRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver

class GetMovieListUseCase(private val naverRepository: NaverRepository) : SingleUseCase<NaverMovieVo,GetMovieListUseCase.Params> {


    override fun invoke(params: Params): Single<NaverMovieVo> {
        return naverRepository.getMovieList(params.quert,params.country)
    }

    data class Params(
        val quert: String,
        val country: String
    )
}