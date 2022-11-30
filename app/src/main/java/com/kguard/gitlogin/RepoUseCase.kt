package com.kguard.gitlogin

import com.kguard.domain.*
import com.kguard.domain.repository.RepoRepository
import javax.inject.Inject

class RepoUseCase @Inject constructor(
    private val repoRepository: RepoRepository,
) {
    suspend fun getRepo(token : String): List<DomainRepo>
    {
        return repoRepository.getRepo(token)
    }



}