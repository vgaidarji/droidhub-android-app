package com.vgaidarji.droidhub.contributions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

@HiltViewModel(assistedFactory = ContributionsViewModel.ContributionsViewModelFactory::class)
class ContributionsViewModel @AssistedInject constructor(
    private val gitHubUserRepository: GitHubUserRepository,
    @Assisted private val gitHubUserName: String
) : ViewModel() {
    private val _uiState = MutableStateFlow(ContributionsUiState.NO_CONTRIBUTIONS)
    val uiState: StateFlow<ContributionsUiState> get() = _uiState

    @AssistedFactory
    interface ContributionsViewModelFactory {
        fun create(gitHubUserName: String): ContributionsViewModel
    }

    init {
        viewModelScope.launch {
            runCatching {
                _uiState.value = _uiState.value.copy(isLoading = true)
                gitHubUserRepository.getUser(gitHubUserName)
            }.onSuccess { gitHubUser ->
                val yearsOfContribution = gitHubUser.createdAt.year.rangeTo(LocalDate.now().year)
                val contributions = gitHubUserRepository.getUserContributions(gitHubUserName, yearsOfContribution.last)
                updateDefaultLastYearContributions(yearsOfContribution, contributions)
            }.onFailure { _ ->
                // TODO: handle errors
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }

    fun loadContributions(owner: String = gitHubUserName, selectedYear: Int) {
        viewModelScope.launch {
            runCatching {
                // TODO: show loading only on for contributions calendar
                _uiState.value = _uiState.value.copy(isLoading = true)
                gitHubUserRepository.getUserContributions(owner, selectedYear)
            }.onSuccess { contributions ->
                updateContributionsForSelectedYear(contributions, selectedYear)
            }.onFailure { _ ->
                // TODO: handle errors
                _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
            }
        }
    }

    private fun updateContributionsForSelectedYear(
        contributions: GitHubUserContributions,
        selectedYear: Int
    ) {
        _uiState.value = _uiState.value.copy(
            gitHubUserContributions = contributions,
            selectedYear = selectedYear,
            isLoading = false
        )
    }

    private fun updateDefaultLastYearContributions(
        yearsOfContribution: IntRange,
        contributions: GitHubUserContributions
    ) {
        _uiState.value = _uiState.value.copy(
            yearsOfContribution = yearsOfContribution,
            selectedYear = yearsOfContribution.last,
            gitHubUserContributions = contributions,
            isLoading = false
        )
    }
}
