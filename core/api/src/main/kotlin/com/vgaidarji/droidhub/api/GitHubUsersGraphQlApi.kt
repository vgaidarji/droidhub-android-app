package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.model.GitHubUserStatus

interface GitHubUsersGraphQlApi {
    suspend fun getGitHubUserStatus(name: String): GitHubUserStatus
}