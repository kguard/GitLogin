package com.kguard.data.repositoryImpl

import com.kguard.data.datasource.TokenDataSource
import com.kguard.data.toDomainAccessToken
import com.kguard.domain.DomainAccessToken
import com.kguard.domain.repository.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(private val api: TokenDataSource): TokenRepository {
    override suspend fun getToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): DomainAccessToken {
        return api.getAccessToken(clientId,clientSecret,code).toDomainAccessToken()
    }
}