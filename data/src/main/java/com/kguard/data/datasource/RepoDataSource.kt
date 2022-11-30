package com.kguard.data.datasource

import com.kguard.data.Repo
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RepoDataSource {
    @Headers("Accept: application/json")
    @GET("user/repos")
    suspend fun getRepositories(
        @Header("authorization") token: String
    ): List<Repo>
}