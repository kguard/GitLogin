package com.kguard.data.datasource

import com.kguard.data.User
import retrofit2.Retrofit
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
private val retrofit: Retrofit
): UserDataSource {
    override suspend fun getUserData(token: String): User {
        return retrofit.create(UserDataSource::class.java).getUserData(token)
    }
}