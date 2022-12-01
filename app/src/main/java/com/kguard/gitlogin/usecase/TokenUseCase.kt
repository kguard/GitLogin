package com.kguard.gitlogin.usecase

import com.kguard.domain.DomainAccessToken
import com.kguard.domain.repository.RepoRepository
import com.kguard.domain.repository.TokenRepository
import com.kguard.domain.repository.UserRepository
import javax.inject.Inject

class TokenUseCase@Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend fun getToken(clientId: String, clientSecret: String, code:String): DomainAccessToken
    {
        return tokenRepository.getToken(clientId,clientSecret,code)
    }
}