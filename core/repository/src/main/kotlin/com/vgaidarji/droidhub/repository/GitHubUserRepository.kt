package com.vgaidarji.droidhub.repository

import com.vgaidarji.droidhub.api.GitHubUsersApi
import com.vgaidarji.droidhub.api.GitHubUsersGraphQlApi
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubUserRepository @Inject constructor(
    private val gitHubUsersApi: GitHubUsersApi,
    private val gitHubUsersGraphQlApi: GitHubUsersGraphQlApi
) {

    suspend fun getGitHubUser(name: String): GitHubUser {
        return gitHubUsersApi.getGitHubUser(name)
    }

    suspend fun getGitHubUserStatus(name: String): GitHubUserStatus {
        return gitHubUsersGraphQlApi.getGitHubUserStatus(name)
    }
}