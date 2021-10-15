package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.data.api.NaverApiService
import com.example.androidepoxy.data.repository.datasource.NaverRemoteDataSource
import com.example.androidepoxy.data.repository.datasourceImpl.NaverRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NaverRemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideGetMovieListFromAPIDataSource(naverApiService: NaverApiService) : NaverRemoteDataSource {
        return NaverRemoteDataSourceImpl(naverApiService)
    }
}