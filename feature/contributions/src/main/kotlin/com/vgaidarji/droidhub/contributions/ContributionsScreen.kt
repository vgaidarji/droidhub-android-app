package com.vgaidarji.droidhub.contributions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
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

@Composable
fun ContributionsCalendar(
    modifier: Modifier = Modifier,
    contributions: GitHubUserContributions
) {
    Text(contributions.totalContributions.toString())
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
fun ContributionsScreenYearsPreview() {
    DroidHubTheme {
        val yearsOfContribution = IntRange(2012, 2024)
        ContributionsScreen(
            modifier = Modifier.fillMaxSize(),
            onYearClicked = {},
            uiState = ContributionsUiState(
                yearsOfContribution = yearsOfContribution,
                selectedYear = yearsOfContribution.last,
                isLoading = false
            )
        )
    }
}
