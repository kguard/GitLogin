package com.kguard.domain.repository

import com.kguard.domain.DomainUser

interface UserRepository {
    suspend fun getUser(token:String): DomainUser
}