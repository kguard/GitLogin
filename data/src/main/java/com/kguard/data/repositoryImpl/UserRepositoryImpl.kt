package com.kguard.data.repositoryImpl

import com.kguard.data.datasource.TokenDataSource
import com.kguard.data.datasource.UserDataSource
import com.kguard.data.toDomainUser
import com.kguard.domain.DomainUser
import com.kguard.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserDataSource): UserRepository {
    override suspend fun getUser(token :String): DomainUser {
        return api.getUserData(token).toDomainUser()
    }

}