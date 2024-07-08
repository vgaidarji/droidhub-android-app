package com.vgaidarji.droidhub.repositories

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.vgaidarji.droidhub.model.GitHubRepository
import com.vgaidarji.droidhub.repository.GitHubUserRepository

class RepositoriesPagingSource(
    private val gitHubUserRepository: GitHubUserRepository
) : PagingSource<Int, GitHubRepository>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubRepository> =
        try {
            // Key may be null during a refresh, if no explicit key is passed into Pager
            // construction. Use 1 as default, because GitHub API is indexed started at index 0
            val pageNumber = params.key ?: 1
            // Suspending network load via Retrofit. This doesn't need to be wrapped in a
            // withContext(Dispatcher.IO) { ... } block since Retrofit's Coroutine
            // CallAdapter dispatches on a worker thread.
            val repositories = gitHubUserRepository.getUserRepositories(
                GITHUB_USER_NAME, page = pageNumber, pageSize = PAGE_SIZE
            )
            // Since 0 is the lowest page number, return null to signify no more pages should
            // be loaded before it.
            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            // This API defines that it's out of data when a page returns empty. When out of
            // data, we return `null` to signify no more pages should be loaded
            val nextKey = if (repositories.isNotEmpty()) pageNumber + 1 else null
            LoadResult.Page(data = repositories, prevKey = prevKey, nextKey = nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, GitHubRepository>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        // TODO: parametrize to allow for loading arbitrary user's profile
        const val GITHUB_USER_NAME = "vgaidarji"
    }
}
