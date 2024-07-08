package com.vgaidarji.droidhub.repository

import com.vgaidarji.droidhub.api.GitHubUsersApi
import com.vgaidarji.droidhub.api.GitHubUsersGraphQlApi
import com.vgaidarji.droidhub.model.GitHubRepository
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubUserRepository @Inject constructor(
    private val gitHubUsersApi: GitHubUsersApi,
    private val gitHubUsersGraphQlApi: GitHubUsersGraphQlApi
) {

    suspend fun getUser(name: String): GitHubUser {
        return gitHubUsersApi.getUser(name)
    }

    suspend fun getUserStatus(name: String): GitHubUserStatus {
        return gitHubUsersGraphQlApi.getUserStatus(name)
    }

    suspend fun getUserRepositories(owner: String, page: Int, pageSize: Int): List<GitHubRepository> {
        return gitHubUsersApi.getUserRepositories(owner, page, pageSize)
    }
}