package com.vgaidarji.droidhub.base.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GitHubUserNameViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<GitHubUserNameUiState> = MutableStateFlow(GitHubUserNameUiState.NO_USER)
    val uiState: StateFlow<GitHubUserNameUiState> = _uiState

    fun updateUser(userName: String) {
        _uiState.value.userName = userName
    }
}