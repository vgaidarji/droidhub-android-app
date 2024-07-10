package com.vgaidarji.droidhub.contributions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.contributions.ui.ContributionsCell
import com.vgaidarji.droidhub.contributions.ui.EmptyCell
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions

@Composable
fun ContributionsScreen(
    modifier: Modifier = Modifier,
    contributionsViewModel: ContributionsViewModel
) {
    val uiState by contributionsViewModel.uiState.collectAsStateWithLifecycle()
    ContributionsScreen(
        modifier,
        { contributionsViewModel.loadContributions(selectedYear = it) },
        uiState
    )
}

@Composable
fun ContributionsScreen(
    modifier: Modifier = Modifier,
    onYearClicked: (Int) -> Unit,
    uiState: ContributionsUiState
) {
    if (uiState.isLoading) {
        ProgressView()
    } else {
        Surface(modifier, color = MaterialTheme.colorScheme.background) {
            Column(
                modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ContributionsYear(
                    yearsOfContribution = uiState.yearsOfContribution,
                    selectedYear = uiState.selectedYear,
                    onYearClicked = onYearClicked
                )
                ContributionsCalendar(contributions = uiState.gitHubUserContributions)
            }
        }
    }
}

/**
 * each month has different number of weeks and this number is returned from API
 * first contributions day of the week may no be on Sunday
 * for 2020 year:
 *
 *           5 weeks   4 weeks 5 weeks
 *           Jan       Feb     Mar      Apr  May  Jun  Jul  Aug  Sep  Oct  Nov  Dec
 * Sunday    - 0 0 0 0 0 0 0 0 0 0 0 0 0                                        0 0
 * Monday    - 1 3 0 0 0 0 0 0 0 0 0 0 0                                        0 0
 * Tuesday   - 0 2 0 0 0 0 0 0 0 0 0 0 0                                        0 0
 * Wednesday 0 0 0 0 0 0 0 0 0 0 0 0 0 0                                        0 0
 * Thursday  1 0 1 0 0 0 0 0 0 0 0 0 0 0                                        0 0
 * Friday    1 0 0 0 0 0 0 0 0 0 0 0 0 0                                        0 -
 * Saturday  0 0 0 0 0 0 0 0 0 0 0 0 0 0                                        0 -
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContributionsCalendar(
    modifier: Modifier = Modifier,
    contributions: GitHubUserContributions
) {
    val pagerState = rememberPagerState(pageCount = {
        // total number of weeks is the number of pager items horizontally
        contributions.months.sumOf { it.totalWeeks }
    })

    HorizontalPager(
        state = pagerState,
        pageSize = PageSize.Fixed(28.dp)
    ) { weekNr ->
        Column (
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier.padding(end = 4.dp)
        ) {
            // calculate number of additional empty days to be added
            var additionalEmptyCells = 0
            if (contributions.weeks[weekNr].contributionDays.size <= 6) {
                additionalEmptyCells = 6 - contributions.weeks[weekNr].contributionDays.size + 1
            }
            // add empty cells before other days for first week
            if (weekNr == 0) {
                repeat(additionalEmptyCells) { EmptyCell() }
            }
            // week days with contributions (if any)
            contributions.weeks[weekNr].contributionDays.forEach { day ->
                ContributionsCell(contributionsDay = day)
            }
            // add empty cells after other days if not first week
            if (weekNr != 0 && additionalEmptyCells > 0) {
                repeat(additionalEmptyCells) { EmptyCell() }
            }
        }
    }
}

@Composable
fun ContributionsYear(modifier: Modifier = Modifier,
                      yearsOfContribution: IntRange,
                      selectedYear: Int,
                      onYearClicked: (Int) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ) {
        Button(
            modifier = modifier
                .wrapContentSize()
                .padding(24.dp),
            onClick = { isExpanded = !isExpanded }
        ) {
            Text(text = selectedYear.toString())
        }

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            yearsOfContribution.forEach { year ->
                DropdownMenuItem(
                    text = { Text(year.toString()) },
                    onClick = {
                        onYearClicked(year)
                    }
                )
            }
        }
    }
}

@Preview(widthDp = 320, heightDp = 320)
@Composable
fun ContributionsScreenLoadingPreview() {
    DroidHubTheme {
        ContributionsScreen(modifier = Modifier.fillMaxSize(), onYearClicked = {}, uiState = ContributionsUiState(isLoading = true))
    }
}

@PreviewWithBackground
@Composable
fun ContributionsScreenYearsPreview(
    @PreviewParameter(GitHubContributionsProvider::class) gitHubUserContributions: GitHubUserContributions
) {
    DroidHubTheme {
        val yearsOfContribution = IntRange(2012, 2024)
        ContributionsScreen(
            modifier = Modifier.fillMaxSize(),
            onYearClicked = {},
            uiState = ContributionsUiState(
                yearsOfContribution = yearsOfContribution,
                selectedYear = yearsOfContribution.last,
                gitHubUserContributions = gitHubUserContributions,
                isLoading = false
            )
        )
    }
}
