package com.kguard.data.repositoryImpl

import com.kguard.data.datasource.RepoDataSource
import com.kguard.data.datasource.TokenDataSource
import com.kguard.data.toDomainRepo
import com.kguard.domain.DomainRepo
import com.kguard.domain.repository.RepoRepository
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(private  val api: RepoDataSource): RepoRepository {
    override suspend fun getRepo(token:String): List<DomainRepo> {
        return api.getRepositories(token).map { it.toDomainRepo() }
    }

}