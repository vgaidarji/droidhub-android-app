package com.vgaidarji.droidhub.contributions

import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions

data class ContributionsUiState(
    val yearsOfContribution: IntRange = IntRange.EMPTY,
    val selectedYear: Int = 0,
    val gitHubUserContributions: GitHubUserContributions = GitHubUserContributions.NO_CONTRIBUTIONS,
    val isError: Boolean = false,
    val isLoading: Boolean = false
) {

    companion object {
        val NO_CONTRIBUTIONS = ContributionsUiState()
    }
}
