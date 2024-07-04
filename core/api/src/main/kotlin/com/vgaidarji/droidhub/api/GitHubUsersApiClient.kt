package com.vgaidarji.droidhub.api

import com.vgaidarji.droidhub.api.model.GitHubRepositoryResponse
import com.vgaidarji.droidhub.api.model.GitHubUserResponse
import com.vgaidarji.droidhub.model.GitHubRepository
import com.vgaidarji.droidhub.model.GitHubUser
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

class GitHubUsersApiClient(retrofit: Retrofit) : GitHubUsersApi {
    interface GitHubUsersService {
        @GET("users/{name}")
        suspend fun getGitHubUser(@Path("name")name: String): GitHubUserResponse

        @GET("users/{owner}/repos")
        suspend fun getGitHubUserRepositories(@Path("owner") owner: String): List<GitHubRepositoryResponse>
    }

    private val service = retrofit.create(GitHubUsersService::class.java)

    override suspend fun getUser(name: String): GitHubUser {
        return withContext(IO) {
            service.getGitHubUser(name).toModel()
        }
    }

    override suspend fun getUserRepositories(owner: String): List<GitHubRepository> {
        return withContext(IO) {
            service.getGitHubUserRepositories(owner).map { response -> response.toModel() }
        }
    }
}
