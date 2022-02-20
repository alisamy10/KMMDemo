package com.example.kmmdemo.data.data_source.network

import com.example.kmmdemo.data.model.UserDto
import com.example.kmmdemo.domain.User
import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient

}


fun UserDto.toDomainUser(): User {
    return User(
        id=id,
                avatar_url= avatarUrl,
        events_url = events_url,
        followers_url = followers_url,
        following_url = following_url,
        gists_url = gists_url,
        gravatar_id = gravatar_id,
        html_url = html_url,
        isFav = isFav,
        login = login,
        node_id = node_id,
        organizations_url = organizations_url,
        received_events_url = received_events_url,
        repos_url = repos_url,
        site_admin = site_admin,
        starred_url = starred_url,
        subscriptions_url = subscriptions_url,
        type = type,
        url = url

    )
}

fun List<UserDto>.toDomainUserList(): List<User>{
    return map{it.toDomainUser()}
}