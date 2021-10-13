package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.domain.repository.NaverRepository
import com.example.androidepoxy.domain.usecase.GetMovieListUseCase
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
    fun provideGetProductListFromAPIUseCase(naverMovieRepository: NaverRepository) : GetMovieListUseCase {
        return GetMovieListUseCase(naverMovieRepository)
    }

}