package com.kguard.domain.repository

import com.kguard.domain.DomainAccessToken

interface TokenRepository {
    suspend fun getToken(clientId: String, clientSecret: String, code:String): DomainAccessToken
}