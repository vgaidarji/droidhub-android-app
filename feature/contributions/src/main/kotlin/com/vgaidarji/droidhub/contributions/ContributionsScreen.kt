package com.vgaidarji.droidhub.contributions

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.Blue
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.viewmodel.GitHubUserNameViewModel
import com.vgaidarji.droidhub.contributions.ui.ContributionsCell
import com.vgaidarji.droidhub.contributions.ui.EmptyCell
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributions
import com.vgaidarji.droidhub.model.contributions.GitHubUserContributionsDay

@Composable
fun ContributionsScreen(
    modifier: Modifier = Modifier,
    gitHubUserName: String,
    onBack: () -> Unit
) {
    val contributionsViewModel: ContributionsViewModel = hiltViewModel<ContributionsViewModel, ContributionsViewModel.ContributionsViewModelFactory> { factory ->
        factory.create(gitHubUserName)
    }
    val uiState by contributionsViewModel.uiState.collectAsStateWithLifecycle()
    BackHandler {
        onBack()
    }
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
        Surface(modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ContributionsHeader(uiState, onYearClicked)
                ContributionsCalendar(contributions = uiState.gitHubUserContributions)
            }
        }
    }
}

@Composable
fun ContributionsHeader(
    uiState: ContributionsUiState,
    onYearClicked: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Text(
                text = pluralStringResource(
                    id = R.plurals.contributions,
                    uiState.gitHubUserContributions.totalContributions,
                    uiState.gitHubUserContributions.totalContributions
                )
            )
        }
        Box (modifier = Modifier.wrapContentSize()) {
            ContributionsYear(
                yearsOfContribution = uiState.yearsOfContribution,
                selectedYear = uiState.selectedYear,
                onYearClicked = onYearClicked
            )
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
    contributions: GitHubUserContributions
) {
    val pagerState = rememberPagerState(pageCount = {
        // total number of weeks is the number of pager items horizontally
        contributions.months.sumOf { it.totalWeeks }
    })

    Row{
        WeekDaysColumn()
        Column {
            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fixed(32.dp)
            ) { weekNr ->
                Column {
                    ContributionsMonthsNamesHeader(contributions, weekNr)
                    ContributionsWeekColumn(
                        contributions.weeks[weekNr].contributionDays,
                        weekNr
                    )
                }
            }
        }
    }
}

@Composable
private fun ContributionsWeekColumn(
    contributionsInGivenWeek: List<GitHubUserContributionsDay>,
    weekNr: Int
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        // calculate number of additional empty days to be added
        var additionalEmptyCells = 0
        if (contributionsInGivenWeek.size <= 6) {
            additionalEmptyCells =
                6 - contributionsInGivenWeek.size + 1
        }
        // add empty cells before other days for first week
        if (weekNr == 0) {
            repeat(additionalEmptyCells) { EmptyCell() }
        }
        // week days with contributions (if any)
        contributionsInGivenWeek.forEach { day ->
            ContributionsCell(contributionsDay = day)
        }
        // add empty cells after other days if not first week
        if (weekNr != 0 && additionalEmptyCells > 0) {
            repeat(additionalEmptyCells) { EmptyCell() }
        }
    }
}

/**
 * Shows month name for a week where first day of the month is found.
 * Otherwise - should show nothing.
 * Each month has different number of weeks
 * so it's important to properly identify the first week for which month should be shown.
 *
 * e.g. nr of weeks for year 2020:
 * Jan 5, Feb 4, Mar 5, Apr 4, May 5, Jun 4,
 * Jul 4, Aug 5, Sep 4, Oct 4, Nov 5, Dec 4
 */
@Composable
private fun ContributionsMonthsNamesHeader(
    contributions: GitHubUserContributions,
    weekNr: Int
) {
    Row {
        Box {
            var isMonthNameShown = false
            contributions.months.forEach forEachMonths@ { month ->
                contributions.weeks[weekNr].contributionDays.forEach { day ->
                    if (day.date.startsWith(month.firstDay)) {
                        isMonthNameShown = true
                        Text(month.name)
                        return@forEachMonths
                    }
                }
            }
            if (!isMonthNameShown) {
                // need to add empty component to preserve the vertical padding
                Text("")
            }
        }
    }
}

@Composable
private fun WeekDaysColumn() {
    Column (modifier = Modifier.padding(end = 4.dp)) {
        Text("")
        Text(
            modifier = Modifier.padding(top = 34.dp),
            text = "Mon")
        Text("")
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Wed"
        )
        Text("")
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Fri"
        )
        Text("")
    }
}

@Composable
fun ContributionsYear(modifier: Modifier = Modifier,
                      yearsOfContribution: IntRange,
                      selectedYear: Int,
                      onYearClicked: (Int) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    Button(
        modifier = modifier
            .height(48.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
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
