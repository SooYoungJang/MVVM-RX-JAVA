package com.example.androidepoxy.domain.repository

import com.example.androidepoxy.domain.model.MenuVo
import retrofit2.Response

interface StarBucksRepository {
    suspend fun getMenu() : Response<MenuVo>
}