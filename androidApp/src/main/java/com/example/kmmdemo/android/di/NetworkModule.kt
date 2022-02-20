package com.example.kmmdemo.android.di

import com.example.kmmdemo.data.data_source.UserService
import com.example.kmmdemo.data.data_source.UserServiceImpl
import com.example.kmmdemo.data.data_source.network.KtorClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient{
        return KtorClientFactory().build()
    }
//
    const val BASE_URL = "https://api.github.com"

    @Singleton
    @Provides
    fun provideRecipeService(
        httpClient: HttpClient,
    ): UserService {
        return UserServiceImpl(
            httpClient = httpClient,
            baseUrl = BASE_URL,
        )
    }
}