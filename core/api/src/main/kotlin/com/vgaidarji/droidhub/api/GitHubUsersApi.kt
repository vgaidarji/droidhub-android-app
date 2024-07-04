package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.model.GitHubUser

interface GitHubUsersApi {
    suspend fun getGitHubUser(name: String): GitHubUser
}
