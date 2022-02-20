package com.example.kmmdemo.di

import com.example.kmmdemo.data.data_source.UserService
import com.example.kmmdemo.data.data_source.UserServiceImpl
import com.example.kmmdemo.data.data_source.network.KtorClientFactory

const val BASE_URL = "https://api.github.com"

class NetworkModule {

    val userService: UserService by lazy {
        UserServiceImpl(
            httpClient = KtorClientFactory().build(),
            baseUrl = BASE_URL
        )
    }


}