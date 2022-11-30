package com.kguard.data.module

import com.kguard.data.datasource.RepoDataSource
import com.kguard.data.datasource.TokenDataSource
import com.kguard.data.datasource.UserDataSource
import com.kguard.data.repositoryImpl.RepoRepositoryImpl
import com.kguard.data.repositoryImpl.TokenRepositoryImpl
import com.kguard.data.repositoryImpl.UserRepositoryImpl
import com.kguard.domain.repository.RepoRepository
import com.kguard.domain.repository.TokenRepository
import com.kguard.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepoRepository(RepoDataSource: RepoDataSource): RepoRepository {
        return RepoRepositoryImpl(RepoDataSource)
    }
    @Provides
    @Singleton
    fun provideUserRepository(UserDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(UserDataSource)
    }
    @Provides
    @Singleton
    fun provideTokenRepository(GitDataSource: TokenDataSource): TokenRepository {
        return TokenRepositoryImpl(GitDataSource)
    }
}