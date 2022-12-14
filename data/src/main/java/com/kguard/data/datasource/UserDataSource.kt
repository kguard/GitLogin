package com.kguard.data.datasource

import com.kguard.data.User
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
//hearder 처리는 인터셉터로 사용
interface UserDataSource {
    @Headers("Accept: application/json")
    @GET("user")
    suspend fun getUserData(
        @Header("authorization") token: String
    ): User
}