package com.vgaidarji.droidhub.repositories

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.component.IconWithText
import com.vgaidarji.droidhub.base.ui.theme.Blue
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.ui.theme.LightBlue
import com.vgaidarji.droidhub.base.ui.theme.LightGray
import com.vgaidarji.droidhub.model.GitHubRepository
import com.vgaidarji.droidhub.model.License
import com.vgaidarji.droidhub.model.RepositoryOwner
import com.vgaidarji.droidhub.model.date.DateFormatter
import com.vgaidarji.droidhub.repositories.ui.EmptyItem
import com.vgaidarji.droidhub.repositories.ui.PaginationErrorItem
import com.vgaidarji.droidhub.repositories.ui.PaginationLoadingItem
import com.vgaidarji.droidhub.repositories.ui.PaginationRetryItem
import kotlinx.coroutines.flow.flowOf
import java.time.LocalDateTime
import com.vgaidarji.droidhub.base.R as RBase

@Composable
fun RepositoriesScreen(
    modifier: Modifier = Modifier,
    repositoriesViewModel: RepositoriesViewModel = hiltViewModel(),
    onBack: () -> Unit
) {
    val repositories = repositoriesViewModel.repositories.collectAsLazyPagingItems()
    BackHandler {
        onBack()
    }
    RepositoriesScreen(modifier.fillMaxSize(), repositories)
}

@Composable
fun RepositoriesScreen(
    modifier: Modifier = Modifier,
    repositories: LazyPagingItems<GitHubRepository>
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState, modifier = modifier.fillMaxSize()) {
        when (repositories.loadState.refresh) {
            LoadState.Loading -> {
                item {
                    PaginationLoadingItem()
                }
            }

            is LoadState.Error -> {
                item {
                    PaginationErrorItem {
                        repositories.refresh()
                    }
                }
            }

            is LoadState.NotLoading -> {
                if (repositories.itemCount < 1) {
                    item {
                        EmptyItem()
                    }
                }
            }
        }
        items(repositories.itemCount) { index ->
            val repository = repositories[index]
            if (repository != null) {
                RepositoryRow(modifier = modifier, repository = repository)
                HorizontalDivider()
            }
        }

        when (repositories.loadState.append) {
            LoadState.Loading -> {
                item {
                    PaginationLoadingItem()
                }
            }

            is LoadState.Error -> {
                item {
                    PaginationRetryItem {
                        repositories.retry()
                    }
                }
            }

            is LoadState.NotLoading -> Unit
        }
    }
}

@Composable
fun RepositoryRow(modifier: Modifier = Modifier, repository: GitHubRepository) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        RepositoryName(modifier, repository.name)
        RepositoryDescription(modifier, repository.description)
        RepositoryTopics(modifier, repository.topics)
        RepositoryMetadata(modifier, repository)
    }
}

@Composable
private fun RepositoryName(modifier: Modifier = Modifier, name: String) {
    Text(
        modifier = modifier.padding(start = 4.dp),
        text = name,
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp
        ),
        color = Blue
    )
}

@Composable
private fun RepositoryDescription(
    modifier: Modifier = Modifier,
    description: String
) {
    if (description.isNotBlank()) {
        Text(
            modifier = modifier.padding(top = 4.dp, start = 4.dp),
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = LightGray
        )
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterialApi::class)
private fun RepositoryTopics(
    modifier: Modifier,
    topics: List<String>
) {
    FlowRow(modifier = modifier.padding(top = 4.dp)) {
        for (topic in topics) {
            Chip(
                modifier = Modifier
                    .padding(2.dp)
                    .height(24.dp),
                onClick = {},
                leadingIcon = {},
                colors = ChipDefaults.chipColors(backgroundColor = LightBlue)
            ) {
                Text(
                    topic,
                    style = TextStyle(fontSize = 12.sp).copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Blue
                )
            }
        }
    }
}

@Composable
private fun RepositoryMetadata(modifier: Modifier = Modifier, repository: GitHubRepository) {
    Row(
        modifier = modifier.padding(start = 4.dp, top = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RepositoryLanguage(language = repository.language)
        RepositoryLicense(license = repository.license)
        RepositoryStargazers(stargazersCount = repository.stargazersCount)
    }
}

@Composable
private fun RepositoryLanguage(language: String) {
    val programmingLanguage = ProgrammingLanguageColor.of(language)
    Image(
        modifier = Modifier.size(10.dp),
        painter = painterResource(programmingLanguage.icon),
        contentDescription = null,
    )
    Text(
        modifier = Modifier.padding(start = 4.dp),
        text = programmingLanguage.title,
        style = MaterialTheme.typography.bodySmall,
        color = LightGray
    )
}

@Composable
private fun RepositoryLicense(license: License) {
    if (license.name.isNotBlank()) {
        IconWithText(
            modifier = Modifier.padding(start = 4.dp),
            iconDrawableRes = RBase.drawable.ic_octicons_law,
            contentDescriptionRes = R.string.content_description_license,
            text = license.name,
            color = LightGray,
            textStartPadding = 0.dp
        )
    }
}

@Composable
private fun RepositoryStargazers(stargazersCount: Int) {
    if (stargazersCount > 0) {
        IconWithText(
            modifier = Modifier.padding(start = 4.dp),
            iconDrawableRes = RBase.drawable.ic_octicons_star,
            contentDescriptionRes = R.string.content_description_stargazers,
            text = stargazersCount.toString(),
            color = LightGray,
            textStartPadding = 0.dp
        )
    }
}

@PreviewWithBackground
@Composable
fun ProfileScreenLoadingPreview() {
    val repositories = listOf(
        GitHubRepository(
            id = 73719271,
            owner = RepositoryOwner(
                id = 3036347,
                login = "vgaidarji",
                avatarUrl = "https://avatars.githubusercontent.com/u/3036347?v=4",
                url = "https://api.github.com/users/vgaidarji"
            ),
            name = "ci-matters",
            description = "Integration (comparison) of different continuous integration services on Android project",
            createdAt = LocalDateTime.from(
                DateFormatter.gitHubApiResponseDate().parse("2016-11-14T15:38:33Z")
            ),
            updatedAt = LocalDateTime.from(
                DateFormatter.gitHubApiResponseDate().parse("2024-03-29T10:13:04Z")
            ),
            stargazersCount = 128,
            watchersCount = 128,
            forksCount = 30,
            language = "Kotlin",
            license = License(
                key = "apache-2.0",
                name = "Apache License 2.0"
            ),
            topics = listOf(
                "android",
                "automation",
                "bitrise",
                "ci",
                "circleci",
                "github-actions",
                "gitlab-ci",
                "jenkins",
                "teamcity"
            )
        ),
        GitHubRepository(
            id = 164016396,
            owner = RepositoryOwner(
                id = 3036347,
                login = "vgaidarji",
                avatarUrl = "https://avatars.githubusercontent.com/u/3036347?v=4",
                url = "https://api.github.com/users/vgaidarji"
            ),
            name = "android-github-actions",
            description = "A GitHub action to build Android projects and run UI tests",
            createdAt = LocalDateTime.from(
                DateFormatter.gitHubApiResponseDate().parse("2019-01-03T19:50:45Z")
            ),
            updatedAt = LocalDateTime.from(
                DateFormatter.gitHubApiResponseDate().parse("2024-01-11T13:54:01Z")
            ),
            stargazersCount = 56,
            watchersCount = 56,
            forksCount = 11,
            language = "Dockerfile",
            license = License(
                key = "apache-2.0",
                name = "Apache License 2.0"
            ),
            topics = listOf("android", "github-actions")
        )
    )

    val repositoriesPagingData = flowOf(
        value = PagingData.from(data = repositories,
        sourceLoadStates = LoadStates(
            refresh = LoadState.NotLoading(false),
            append = LoadState.NotLoading(false),
            prepend = LoadState.NotLoading(false),
        ))
    ).collectAsLazyPagingItems()

    DroidHubTheme {
        RepositoriesScreen(
            modifier = Modifier.fillMaxSize(),
            repositories = repositoriesPagingData
        )
    }
}

@Composable
@PreviewWithBackground
fun PreviewPaginationLoadingItem() {
    DroidHubTheme {
        PaginationLoadingItem()
    }
}

@Composable
@PreviewWithBackground
fun PreviewPaginationErrorItem() {
    DroidHubTheme {
        PaginationErrorItem {}
    }
}

@Composable
@PreviewWithBackground
fun PreviewEmptyItem() {
    DroidHubTheme {
        EmptyItem()
    }
}

@Composable
@PreviewWithBackground
fun PreviewPaginationRetryItem() {
    DroidHubTheme {
        PaginationRetryItem {}
    }
}
