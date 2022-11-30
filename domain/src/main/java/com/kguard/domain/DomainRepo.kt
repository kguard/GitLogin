package com.kguard.domain

data class DomainRepo(
    val id: Int,
    val name: String,
    val isPrivate: Boolean,
    val language: String
)
