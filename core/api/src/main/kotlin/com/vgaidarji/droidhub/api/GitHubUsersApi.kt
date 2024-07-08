package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.model.GitHubRepository
import com.vgaidarji.droidhub.model.GitHubUser

interface GitHubUsersApi {
    suspend fun getUser(name: String): GitHubUser

    suspend fun getUserRepositories(owner: String, page: Int, pageSize: Int): List<GitHubRepository>
}
