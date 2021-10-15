package com.example.androidepoxy.data.repository

import com.example.androidepoxy.data.mapper.toDomain
import com.example.androidepoxy.data.repository.datasource.NaverRemoteDataSource
import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.model.NaverShopVo
import com.example.androidepoxy.domain.repository.NaverRepository
import io.reactivex.rxjava3.core.Single

class NaverRepositoryImpl(private val naverRemoteDataSource: NaverRemoteDataSource) :
    NaverRepository {
    override fun getMovieList(query: String, country: String): Single<NaverMovieVo> {
        return naverRemoteDataSource.getMovieList(query, country).map { it.toDomain() }
    }

    override fun getShopList(query: String): Single<NaverShopVo> {
        return naverRemoteDataSource.getShopList(query).map { it.toDomain() }
    }
}