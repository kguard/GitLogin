package com.kguard.gitlogin.usecase

import com.kguard.domain.DomainUser
import com.kguard.domain.repository.RepoRepository
import com.kguard.domain.repository.TokenRepository
import com.kguard.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun getUser(token: String) : DomainUser
    {
        return userRepository.getUser(token)
    }
}