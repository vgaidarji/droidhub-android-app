package com.vgaidarji.droidhub.model

import java.time.LocalDateTime

data class GitHubRepository(
    val id: Int,
    val owner: RepositoryOwner,
    val name: String,
    val description: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val stargazersCount: Int,
    val watchersCount: Int,
    val forksCount: Int,
    val language: String,
    val license: License,
    val topics: List<String>
) {

    companion object {
        val EMPTY = GitHubRepository(
            id = -1,
            owner = RepositoryOwner.EMPTY,
            name = "",
            description = "",
            createdAt = LocalDateTime.MIN,
            updatedAt = LocalDateTime.MIN,
            stargazersCount = 0,
            watchersCount = 0,
            forksCount = 0,
            language = "",
            license = License.EMPTY,
            topics = emptyList()
        )
    }
}

