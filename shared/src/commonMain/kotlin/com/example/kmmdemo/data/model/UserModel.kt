package com.example.kmmdemo.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class UserDto(

    @SerialName("avatar_url")
    val avatarUrl: String="",
    val events_url: String="",
    val followers_url: String="",
    val following_url: String="",
    val gists_url: String="",
    val gravatar_id: String="",
    val html_url: String="",
    val id: Int,
    val login: String="",
    val node_id: String="",
    val organizations_url: String="",
    val received_events_url: String="",
    val repos_url: String="",
    val site_admin: Boolean=false,
    val starred_url: String="",
    val subscriptions_url: String="",
    val type: String="",
    val url: String="",
    var isFav:Boolean=false,
)
