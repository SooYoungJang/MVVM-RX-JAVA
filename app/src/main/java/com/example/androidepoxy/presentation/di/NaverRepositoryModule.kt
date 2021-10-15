package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.data.repository.NaverRepositoryImpl
import com.example.androidepoxy.data.repository.datasource.NaverRemoteDataSource
import com.example.androidepoxy.domain.repository.NaverRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NaverRepositoryModule {

    @Singleton
    @Provides
    fun provideGetMovieListFromAPIRepository(naverRemoteDataSource: NaverRemoteDataSource) : NaverRepository {
        return NaverRepositoryImpl(naverRemoteDataSource)
    }
}