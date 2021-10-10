package com.example.androidepoxy.api

import com.example.androidepoxy.model.MenuResponse
import retrofit2.http.GET

interface StarBucksApiService {

    @GET("bff/ordering/menu")
    suspend fun getMenu(): MenuResponse
}