package com.example.androidepoxy.data.repository.datasourceImpl

import com.example.androidepoxy.data.api.NaverApiService
import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.data.model.NaverShopResponse
import com.example.androidepoxy.data.repository.datasource.NaverRemoteDataSource
import io.reactivex.rxjava3.core.Single

class NaverRemoteDataSourceImpl(private val naverApiService: NaverApiService) :NaverRemoteDataSource {

    override fun getMovieList(query: String, country : String): Single<NaverMovieResponse> {
        return naverApiService.getMovieList(query,country)
    }

    override fun getShopList(query: String): Single<NaverShopResponse> {
        return naverApiService.getShopList(query)
    }
}