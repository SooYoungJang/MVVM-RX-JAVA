package com.example.androidepoxy.data.api

import com.example.androidepoxy.data.model.MenuResponse
import retrofit2.Response
import retrofit2.http.GET

interface StarBucksApiService {

    @GET("bff/ordering/menu")
    suspend fun getMenu(): Response<MenuResponse>
}