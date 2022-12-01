package com.kguard.data

import com.google.gson.annotations.SerializedName
import com.kguard.domain.DomainUser

data class User(
    @SerializedName("login")
    val username: String,
    val name: String,
    val email: String?,
    val bio: String?,
    val location: String?,
    val followers: Int,
    val following: Int,
)
fun User.toDomainUser() : DomainUser = DomainUser(
    username, name, email, bio, location, followers, following
)