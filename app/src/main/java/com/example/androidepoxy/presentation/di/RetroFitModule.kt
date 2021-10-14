package com.example.androidepoxy.presentation.di

import com.example.androidepoxy.data.api.NaverMovieApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetroFitModule {

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .client(httpClient)
            .baseUrl("https://openapi.naver.com")
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit) : NaverMovieApiService {
        return retrofit.create(NaverMovieApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectionPool(ConnectionPool(5, 20, TimeUnit.SECONDS))
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    level = HttpLoggingInterceptor.Level.BODY
                )
            )
            .build()
    }
}