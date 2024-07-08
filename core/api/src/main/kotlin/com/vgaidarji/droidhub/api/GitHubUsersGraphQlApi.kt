package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.model.GitHubUserStatus

interface GitHubUsersGraphQlApi {
    suspend fun getUserStatus(name: String): GitHubUserStatus
}