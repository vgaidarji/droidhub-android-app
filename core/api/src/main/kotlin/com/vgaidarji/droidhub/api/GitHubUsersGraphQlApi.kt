package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.model.GitHubUserStatus
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions

interface GitHubUsersGraphQlApi {
    suspend fun getUserStatus(name: String): GitHubUserStatus

    suspend fun getUserContributions(name: String, yearOfContribution: Int): GitHubUserContributions
}