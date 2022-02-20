package com.example.kmmdemo.data.data_source

import com.example.kmmdemo.data.data_source.network.toDomainUserList
import com.example.kmmdemo.data.model.UserDto
import com.example.kmmdemo.domain.User
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.*
import io.ktor.client.request.*

interface UserService {

     suspend fun getUsers(): List<User>
}


class  UserServiceImpl (private val httpClient: HttpClient,
                        private val baseUrl: String,) :UserService{
     override suspend fun getUsers()=
          httpClient.get<List<UserDto>> {
          url("${baseUrl}/users")
     }.toDomainUserList()

}