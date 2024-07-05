package com.vgaidarji.droidhub.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
    private val gitHubUserRepository: GitHubUserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(RepositoriesUiState.NO_REPOSITORIES)
    val uiState: StateFlow<RepositoriesUiState> get() = _uiState
    // TODO: parametrize to allow for loading arbitrary user's profile
    val GITHUB_USER_NAME = "vgaidarji"

    init {
        viewModelScope.launch {
            runCatching {
                setLoadingState()
                gitHubUserRepository.getUserRepositories(GITHUB_USER_NAME)
            }.onSuccess { repositories ->
                _uiState.value = _uiState.value.copy(repositories = repositories, isLoading = false)
            }.onFailure { _ ->
                setErrorState()
                // TODO: handle errors
            }
        }
    }

    private fun setErrorState() {
        _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
    }

    private fun setLoadingState() {
        _uiState.value = _uiState.value.copy(isLoading = true)
    }
}
