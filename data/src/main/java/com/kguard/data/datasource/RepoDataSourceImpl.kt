package com.kguard.data.datasource

import com.kguard.data.Repo
import retrofit2.Retrofit
import javax.inject.Inject

class RepoDataSourceImpl @Inject constructor(
    private val retrofit: Retrofit
): RepoDataSource {
    override suspend fun getRepositories(token: String): List<Repo> {
        return retrofit.create(RepoDataSource::class.java).getRepositories(token)
    }

}