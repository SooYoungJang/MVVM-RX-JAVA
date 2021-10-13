package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.data.api.NaverMovieApiService
import com.example.androidepoxy.data.repository.NaverRepositoryImpl
import com.example.androidepoxy.data.repository.datasource.NaverMovieRemoteDataSource
import com.example.androidepoxy.data.repository.datasourceImpl.NaverMovieRemoteDataSourceImpl
import com.example.androidepoxy.domain.repository.NaverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NaverMovieRemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideGetMovieListFromAPIDataSource(naverMovieApiService: NaverMovieApiService) : NaverMovieRemoteDataSource {
        return NaverMovieRemoteDataSourceImpl(naverMovieApiService)
    }
}