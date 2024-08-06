package com.vgaidarji.droidhub.base.viewmodel

data class GitHubUserNameUiState(
    var userName: String = ""
) {
    companion object {
        val NO_USER = GitHubUserNameUiState()
    }
}
