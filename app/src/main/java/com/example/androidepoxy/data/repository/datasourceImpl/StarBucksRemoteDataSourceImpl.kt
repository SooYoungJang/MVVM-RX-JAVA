package com.example.androidepoxy.data.repository.datasourceImpl

import com.example.androidepoxy.data.api.StarBucksApiService
import com.example.androidepoxy.data.model.MenuResponse
import com.example.androidepoxy.data.repository.datasource.StarBucksRemoteDataSource
import retrofit2.Response

class StarBucksRemoteDataSourceImpl(private val starBucksApiService: StarBucksApiService) :StarBucksRemoteDataSource {

    override suspend fun getMenu(): Response<MenuResponse> {
        return starBucksApiService.getMenu()
    }

}