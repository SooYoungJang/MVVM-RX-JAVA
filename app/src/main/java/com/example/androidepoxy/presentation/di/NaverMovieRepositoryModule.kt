package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.data.repository.NaverRepositoryImpl
import com.example.androidepoxy.data.repository.datasource.NaverMovieRemoteDataSource
import com.example.androidepoxy.domain.repository.NaverRepository
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NaverMovieRepositoryModule {

    @Singleton
    @Provides
    fun provideGetMovieListFromAPIRepository(naverMovieRemoteDataSource: NaverMovieRemoteDataSource) : NaverRepository {
        return NaverRepositoryImpl(naverMovieRemoteDataSource)
    }
}