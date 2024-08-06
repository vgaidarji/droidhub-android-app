package com.vgaidarji.droidhub.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import com.vgaidarji.droidhub.repository.GitHubUserRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel(assistedFactory = ProfileViewModel.ProfileViewModelFactory::class)
class ProfileViewModel @AssistedInject constructor(
    private val gitHubUserRepository: GitHubUserRepository,
    @Assisted private val gitHubUserName: String
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState.NO_USER)
    val uiState: StateFlow<ProfileUiState> get() = _uiState

    @AssistedFactory
    interface ProfileViewModelFactory {
        fun create(gitHubUserName: String): ProfileViewModel
    }

    init {
        viewModelScope.launch {
            setLoadingState()

            var user: GitHubUser = GitHubUser.NO_USER
            var userStatus: GitHubUserStatus = GitHubUserStatus.NO_USER_STATUS
            try {
                fetchGitHubUserProfile(gitHubUserName).also {
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

    private suspend fun fetchGitHubUserProfile(gitHubUserName: String): Pair<GitHubUser, GitHubUserStatus> {
        var gitHubUser: GitHubUser = GitHubUser.NO_USER
        var gitHubUserStatus: GitHubUserStatus = GitHubUserStatus.NO_USER_STATUS
        coroutineScope {
            launch {
                gitHubUser = gitHubUserRepository.getUser(gitHubUserName)
            }
            launch {
                gitHubUserStatus = gitHubUserRepository.getUserStatus(gitHubUserName)
            }
        }
        return Pair(gitHubUser, gitHubUserStatus)
    }
}
