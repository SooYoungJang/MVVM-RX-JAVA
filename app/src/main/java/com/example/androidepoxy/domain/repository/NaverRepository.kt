package com.example.androidepoxy.domain.repository

import com.example.androidepoxy.domain.model.NaverMovieVo
import io.reactivex.rxjava3.core.Single

interface NaverRepository {
    fun getMovieList(query: String, country: String) : Single<NaverMovieVo>
}