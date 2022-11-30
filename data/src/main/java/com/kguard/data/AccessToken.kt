package com.kguard.data

import com.google.gson.annotations.SerializedName
import com.kguard.domain.DomainAccessToken


data class AccessToken (
    @SerializedName("access_token")
    val accessToken: String,
)
fun AccessToken.toDomainAccessToken() : DomainAccessToken = DomainAccessToken(
    accessToken=accessToken
)