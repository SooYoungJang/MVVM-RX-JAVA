package com.example.androidepoxy.di

import com.example.androidepoxy.api.StarBucksApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetroFitModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.starbucks.com/")
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : StarBucksApiService {
        return retrofit.create(StarBucksApiService::class.java)
    }
}