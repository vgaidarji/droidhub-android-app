package com.vgaidarji.droidhub.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.vgaidarji.droidhub.repositories.RepositoriesPagingSource.Companion.PAGE_SIZE
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val gitHubUserRepository: GitHubUserRepository
) : ViewModel() {
    val repositories = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { RepositoriesPagingSource(gitHubUserRepository) }
    ).flow.cachedIn(scope = viewModelScope)
}
