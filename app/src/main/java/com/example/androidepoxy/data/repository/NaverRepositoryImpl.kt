package com.example.androidepoxy.data.repository

import com.example.androidepoxy.data.mapper.toDomain
import com.example.androidepoxy.data.repository.datasource.NaverMovieRemoteDataSource
import com.example.androidepoxy.domain.model.NaverMovieVo
import com.example.androidepoxy.domain.repository.NaverRepository
import io.reactivex.rxjava3.core.Single

class NaverRepositoryImpl(private val naverMovieRemoteDataSource: NaverMovieRemoteDataSource) :
    NaverRepository {
    override fun getMovieList(query: String, country: String): Single<NaverMovieVo> {
        return naverMovieRemoteDataSource.getMovieList(query, country).map { it.toDomain() }
    }
}