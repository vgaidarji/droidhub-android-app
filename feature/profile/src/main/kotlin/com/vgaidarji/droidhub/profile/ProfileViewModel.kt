package com.vgaidarji.droidhub.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val gitHubUserRepository: GitHubUserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState.NO_USER)
    val uiState: StateFlow<ProfileUiState> get() = _uiState
    // TODO: parametrize to allow for loading arbitrary user's profile
    val GITHUB_USER_NAME = "vgaidarji"

    init {
        viewModelScope.launch {
            setLoadingState()

            var user: GitHubUser = GitHubUser.NO_USER
            var userStatus: GitHubUserStatus = GitHubUserStatus.NO_USER_STATUS
            try {
                fetchGitHubUserProfile().also {
                    user = it.first
                    userStatus = it.second
                }
            } catch (e: Exception) {
                Timber.e(e)
                setErrorState()
            }

            setLoadedProfileState(user, userStatus)
        }
    }

    private fun setErrorState() {
        _uiState.value = _uiState.value.copy(isLoading = false, isError = true)
    }

    private fun setLoadingState() {
        _uiState.value = _uiState.value.copy(isLoading = true)
    }

    private fun setLoadedProfileState(
        user: GitHubUser,
        userStatus: GitHubUserStatus
    ) {
        _uiState.value = _uiState.value.copy(
            gitHubUser = user,
            gitHubUserStatus = userStatus,
            isLoading = false
        )
    }

    private suspend fun fetchGitHubUserProfile(): Pair<GitHubUser, GitHubUserStatus> {
        var gitHubUser: GitHubUser = GitHubUser.NO_USER
        var gitHubUserStatus: GitHubUserStatus = GitHubUserStatus.NO_USER_STATUS
        coroutineScope {
            launch {
                gitHubUser = gitHubUserRepository.getGitHubUser(GITHUB_USER_NAME)
            }
            launch {
                gitHubUserStatus = gitHubUserRepository.getGitHubUserStatus(GITHUB_USER_NAME)
            }
        }
        return Pair(gitHubUser, gitHubUserStatus)
    }
}
