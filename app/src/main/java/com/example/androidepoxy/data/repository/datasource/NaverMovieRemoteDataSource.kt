package com.example.androidepoxy.data.repository.datasource

import com.example.androidepoxy.data.model.NaverMovieResponse
import io.reactivex.rxjava3.core.Single

interface NaverMovieRemoteDataSource {
    fun getMovieList(query: String, country : String) : Single<NaverMovieResponse>
}