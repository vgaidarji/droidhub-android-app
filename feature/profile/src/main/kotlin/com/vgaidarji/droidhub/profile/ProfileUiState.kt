package com.vgaidarji.droidhub.profile

import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus

data class ProfileUiState(
    val gitHubUser: GitHubUser = GitHubUser.NO_USER,
    val gitHubUserStatus: GitHubUserStatus = GitHubUserStatus.NO_USER_STATUS,
    val isError: Boolean = false,
    val isLoading: Boolean = false
) {

    companion object {
        val NO_USER = ProfileUiState()
    }
}
