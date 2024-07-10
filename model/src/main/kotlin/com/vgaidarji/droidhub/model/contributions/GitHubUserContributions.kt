package com.vgaidarji.droidhub.model.contributions

data class GitHubUserContributions(
    /**
     * The count of total contributions in the calendar.
     */
    val totalContributions: Int,
    /**
     * A list of the weeks of contributions in this calendar.
     */
    val weeks: List<GitHubUserContributionsWeek>,
    /**
     * A list of the months of contributions in this calendar.
     */
    val months: List<GitHubUserContributionsMonth>
) {
    companion object {
        val NO_CONTRIBUTIONS = GitHubUserContributions(
            totalContributions = 0,
            weeks = emptyList(),
            months = emptyList()
        )
    }
}

data class GitHubUserContributionsWeek(
    /**
     * A calendar of this user's contributions on GitHub.
     */
    val contributionDays: List<GitHubUserContributionsDay>
)

data class GitHubUserContributionsMonth(
    /**
     * The name of the month.
     */
    val name: String,
    /**
     * The year the month occurred in.
     */
    val year: Int,
    /**
     * The date of the first day of this month.
     */
    val firstDay: Any,
    /**
     * How many weeks started in this month.
     */
    val totalWeeks: Int,
)

data class GitHubUserContributionsDay(
    /**
     * A number representing which day of the week this square represents, e.g., 1 is Monday.
     */
    val weekday: Int,
    /**
     * The day this square represents.
     */
    val date: Any,
    /**
     * How many contributions were made by the user on this day.
     */
    val contributionCount: Int,
    /**
     * The hex color code that represents how many contributions were made on this day compared to
     * others in the calendar.
     */
    val color: String
)
