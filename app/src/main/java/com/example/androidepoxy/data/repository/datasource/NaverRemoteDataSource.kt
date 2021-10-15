package com.example.androidepoxy.data.repository.datasource

import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.data.model.NaverShopResponse
import io.reactivex.rxjava3.core.Single

interface NaverRemoteDataSource {
    fun getMovieList(query: String, country : String) : Single<NaverMovieResponse>
    fun getShopList(query: String) : Single<NaverShopResponse>
}