package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.domain.repository.NaverRepository
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
import com.example.androidepoxy.domain.usecase.GetShopListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieListFromAPIUseCase(naverMovieRepository: NaverRepository) : GetMovieListUseCase {
        return GetMovieListUseCase(naverMovieRepository)
    }

    @Singleton
    @Provides
    fun provideGetProductListFromAPIUseCase(naverMovieRepository: NaverRepository) : GetShopListUseCase {
        return GetShopListUseCase(naverMovieRepository)
    }

}