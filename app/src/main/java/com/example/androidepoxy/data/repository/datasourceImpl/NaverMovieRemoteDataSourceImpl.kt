package com.example.androidepoxy.data.repository.datasourceImpl

import com.example.androidepoxy.data.api.NaverMovieApiService
import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.data.repository.datasource.NaverMovieRemoteDataSource
import io.reactivex.rxjava3.core.Single

class NaverMovieRemoteDataSourceImpl(private val naverMovieApiService: NaverMovieApiService) :NaverMovieRemoteDataSource {

    override fun getMovieList(query: String, country : String): Single<NaverMovieResponse> {
        return naverMovieApiService.getMovieList(query,country)
    }
}