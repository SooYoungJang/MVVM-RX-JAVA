package com.example.androidepoxy.data.repository.datasource

import androidx.annotation.MenuRes
import com.example.androidepoxy.data.model.MenuResponse
import retrofit2.Response

interface StarBucksRemoteDataSource {
    suspend fun getMenu() : Response<MenuResponse>
}