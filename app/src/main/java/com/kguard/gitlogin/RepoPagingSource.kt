package com.kguard.gitlogin

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kguard.data.Repo
import com.kguard.data.datasource.RepoDataSource
import com.kguard.domain.DomainRepo

class RepoPagingSource(val repo: RepoDataSource, val token: String) :
    PagingSource<Int, Repo>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> {
        val nextPage = params.key ?: 0
        val response = repo.getRepositories(token)
        return LoadResult.Page(
            data = response,
            prevKey = null,
            nextKey = nextPage+1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int =0



}