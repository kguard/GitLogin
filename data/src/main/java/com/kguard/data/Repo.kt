package com.kguard.data

import com.google.gson.annotations.SerializedName
import com.kguard.domain.DomainRepo

data class Repo(
    val id: Int,
    val name: String,
    @SerializedName("private")
    val isPrivate: Boolean,
    val language: String
)
fun Repo.toDomainRepo() : DomainRepo = DomainRepo(
    id, name, isPrivate, language
)
