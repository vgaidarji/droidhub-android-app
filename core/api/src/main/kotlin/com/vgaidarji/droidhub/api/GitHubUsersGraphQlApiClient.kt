package com.vgaidarji.droidhub.api

import com.apollographql.apollo3.ApolloClient
import com.vgaidarji.droidhub.model.GitHubUserStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubUsersGraphQlApiClient(apolloClient: ApolloClient) : GitHubUsersGraphQlApi {
    private val client = apolloClient
    override suspend fun getGitHubUserStatus(name: String): GitHubUserStatus {
        return withContext(Dispatchers.IO) {
            val response = client.query(GitHubUserStatusQuery(user = name)).execute()
            response.data?.user?.status.toModel()
        }
    }
}

private fun GitHubUserStatusQuery.Status?.toModel(): GitHubUserStatus =
    GitHubUserStatus(
        emoji = this?.emoji ?: "",
        emojiHtml = this?.emojiHTML.toString(),
        expiresAt = this?.expiresAt.toString(),
        limitedAvailability = this?.limitedAvailability.toString(),
        message = this?.message.toString()
    )
