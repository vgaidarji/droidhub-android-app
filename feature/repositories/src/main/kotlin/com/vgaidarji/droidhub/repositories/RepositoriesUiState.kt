package com.vgaidarji.droidhub.repositories

import com.vgaidarji.droidhub.model.GitHubRepository

data class RepositoriesUiState(
    val repositories: List<GitHubRepository> = emptyList(),
    val isError: Boolean = false,
    val isLoading: Boolean = false
) {

    companion object {
        val NO_REPOSITORIES = RepositoriesUiState()
    }
}
