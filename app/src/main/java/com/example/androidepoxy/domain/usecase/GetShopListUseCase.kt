package com.example.androidepoxy.domain.usecase

import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.model.NaverShopVo
import com.example.androidepoxy.domain.repository.NaverRepository
import io.reactivex.rxjava3.core.Single

class GetShopListUseCase (private val naverRepository: NaverRepository) : SingleUseCase<NaverShopVo,GetShopListUseCase.Params> {


    override fun invoke(params: Params): Single<NaverShopVo> {
        return naverRepository.getShopList(params.query)
    }

    data class Params(
        val query: String
    )

}