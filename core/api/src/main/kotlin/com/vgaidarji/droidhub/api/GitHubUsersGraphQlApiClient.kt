package com.vgaidarji.droidhub.api

import com.apollographql.apollo3.ApolloClient
import com.vgaidarji.droidhub.model.GitHubUserStatus
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributionsDay
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributionsMonth
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributionsWeek
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GitHubUsersGraphQlApiClient(apolloClient: ApolloClient) : GitHubUsersGraphQlApi {
    private val client = apolloClient
    override suspend fun getUserStatus(name: String): GitHubUserStatus {
        return withContext(Dispatchers.IO) {
            val response = client.query(GitHubUserStatusQuery(user = name)).execute()
            response.data?.user?.status.toModel()
        }
    }

    override suspend fun getUserContributions(
        name: String,
        yearOfContribution: Int,
    ): GitHubUserContributions {
        return withContext(Dispatchers.IO) {
            val response = client.query(
                GitHubUserContributionsQuery(
                    user = name,
                    dateFrom = "$yearOfContribution-01-01T00:00:00Z",
                    dateTo = "$yearOfContribution-12-31T23:59:59Z"
                )
            ).execute()
            response.data?.user?.contributionsCollection?.contributionCalendar.toModel()
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


private fun GitHubUserContributionsQuery.ContributionCalendar?.toModel(): GitHubUserContributions =
    GitHubUserContributions(
        totalContributions = this?.totalContributions ?: 0,
        weeks = this?.weeks?.map { week ->
            GitHubUserContributionsWeek(
                contributionDays = week.contributionDays.map {day ->
                    GitHubUserContributionsDay(
                        weekday = day.weekday,
                        date = day.date.toString(),
                        contributionCount = day.contributionCount,
                        color = day.color
                    )
                }
            )
        } ?: emptyList(),
        months = this?.months?.map { month ->
            GitHubUserContributionsMonth(
                name = month.name,
                year = month.year,
                firstDay = month.firstDay.toString(),
                totalWeeks = month.totalWeeks,
            )
        } ?: emptyList(),
    )