package com.vgaidarji.droidhub.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.vgaidarji.droidhub.repositories.RepositoriesPagingSource.Companion.PAGE_SIZE
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = RepositoriesViewModel.RepositoriesViewModelFactory::class)
class RepositoriesViewModel @AssistedInject constructor(
    private val gitHubUserRepository: GitHubUserRepository,
    @Assisted private val gitHubUserName: String
) : ViewModel() {

    @AssistedFactory
    interface RepositoriesViewModelFactory {
        fun create(gitHubUserName: String): RepositoriesViewModel
    }

    val repositories = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { RepositoriesPagingSource(gitHubUserRepository, gitHubUserName) }
    ).flow.cachedIn(scope = viewModelScope)
}
