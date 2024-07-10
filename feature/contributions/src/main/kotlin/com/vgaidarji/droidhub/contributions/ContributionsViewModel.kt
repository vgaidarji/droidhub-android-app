package com.vgaidarji.droidhub.contributions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
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
                gitHubUserRepository.getUser(GITHUB_USER_NAME)
            }.onSuccess { gitHubUser ->
                val yearsOfContribution = gitHubUser.createdAt.year.rangeTo(LocalDate.now().year)
                _uiState.value = _uiState.value.copy(
                    yearsOfContribution = yearsOfContribution,
                    selectedYear = yearsOfContribution.last,
                    isLoading = false
                )
            }.onFailure { error ->
                // TODO: handle errors
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }

    fun loadContributions(owner: String = GITHUB_USER_NAME, selectedYear: Int) {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                gitHubUserRepository.getUserContributions(owner, selectedYear)
            }.onSuccess { contributions ->
                _uiState.value = _uiState.value.copy(
                    gitHubUserContributions = contributions,
                    selectedYear = selectedYear,
                    isLoading = false
                )
            }.onFailure { error ->
                // TODO: handle errors
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }
}
