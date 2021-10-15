package com.example.androidepoxy.data.api

import com.example.androidepoxy.data.model.NaverMovieResponse
import com.example.androidepoxy.data.model.NaverShopResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NaverApiService {

    @GET("/v1/search/movie.json")
    fun getMovieList(
        @Query("query") query: String,
        @Query("country") country: String,
        @Header("X-Naver-Client-Id") clientId : String = "rQB8DeYMGqd8Z23jKaJy",
        @Header("X-Naver-Client-Secret") clientSecretKey:String = "jzUCat64Fz"
    ): Single<NaverMovieResponse>

    @GET("/v1/search/shop.json")
    fun getShopList(
        @Query("query") query: String,
        @Header("X-Naver-Client-Id") clientId : String = "rQB8DeYMGqd8Z23jKaJy",
        @Header("X-Naver-Client-Secret") clientSecretKey:String = "jzUCat64Fz"
    ): Single<NaverShopResponse>

}