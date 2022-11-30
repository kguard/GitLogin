package com.kguard.data

import com.kguard.domain.DomainRepo

data class Repo(
    val id: Int,
    val name: String,
    val isPrivate: Boolean,
    val language: String
)
fun Repo.toDomainRepo() : DomainRepo = DomainRepo(
    id, name, isPrivate, language
)
