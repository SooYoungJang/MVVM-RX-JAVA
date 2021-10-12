package com.example.androidepoxy.data.repository

import com.example.androidepoxy.data.repository.datasource.StarBucksRemoteDataSource
import com.example.androidepoxy.domain.model.MenuVo
import com.example.androidepoxy.domain.repository.StarBucksRepository
import retrofit2.Response
  
class StarBucksRepositoryImpl(private val starBucksRemoteDataSource: StarBucksRemoteDataSource) : StarBucksRepository {
    override suspend fun getMenu(): Response<MenuVo> {
       return starBucksRemoteDataSource.getMenu().
    }

}