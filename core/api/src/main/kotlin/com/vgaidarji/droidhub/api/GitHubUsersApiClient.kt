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
import retrofit2.http.Query

class GitHubUsersApiClient(retrofit: Retrofit) : GitHubUsersApi {
    interface GitHubUsersService {
        @GET("users/{name}")
        suspend fun getGitHubUser(@Path("name")name: String): GitHubUserResponse

        // https://docs.github.com/en/rest/repos/repos?apiVersion=2022-11-28#list-repositories-for-a-user
        @GET("users/{owner}/repos")
        suspend fun getGitHubUserRepositories(
            @Path("owner") owner: String,
            @Query("page") page: Int,
            @Query("per_page") pageSize: Int
        ): List<GitHubRepositoryResponse>
    }

    private val service = retrofit.create(GitHubUsersService::class.java)

    override suspend fun getUser(name: String): GitHubUser {
        return withContext(IO) {
            service.getGitHubUser(name).toModel()
        }
    }

    override suspend fun getUserRepositories(owner: String, page: Int, pageSize: Int): List<GitHubRepository> {
        return withContext(IO) {
            service.getGitHubUserRepositories(owner, page, pageSize).map { response -> response.toModel() }
        }
    }
}
