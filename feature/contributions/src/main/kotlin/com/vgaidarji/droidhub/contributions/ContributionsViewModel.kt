package com.vgaidarji.droidhub.contributions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContributionsViewModel @Inject constructor(
    private val gitHubUserRepository: GitHubUserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ContributionsUiState.NO_CONTRIBUTIONS)
    val uiState: StateFlow<ContributionsUiState> get() = _uiState
    // TODO: parametrize to allow for loading arbitrary user's profile
    val GITHUB_USER_NAME = "vgaidarji"
    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                // TODO: pass in the contributions year
                gitHubUserRepository.getUserContributions(GITHUB_USER_NAME, 2020)
            }.onSuccess { contributions ->
                _uiState.value = _uiState.value.copy(
                    gitHubUserContributions = contributions,
                    isLoading = false
                )
            }.onFailure { error ->
                // TODO: handle errors
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }
}
