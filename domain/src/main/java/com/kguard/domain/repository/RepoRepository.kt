package com.kguard.domain.repository

import com.kguard.domain.DomainRepo

interface RepoRepository {
    suspend fun getRepo(token:String):List<DomainRepo>
}