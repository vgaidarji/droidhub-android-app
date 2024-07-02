package com.vgaidarji.droidhub.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.ui.theme.customColorsPalette
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus

val contentWidth = 250.dp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, profileViewModel: ProfileViewModel) {
    val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()
    ProfileScreen(modifier, uiState)
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, uiState: ProfileUiState) {
    if (uiState.isLoading) {
        ProgressView()
    } else {
        Surface(modifier, color = MaterialTheme.colorScheme.background) {
            Column(
                modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileAvatar(
                    avatarUrl = uiState.gitHubUser.avatarUrl,
                    statusEmojiHtml = uiState.gitHubUserStatus.emojiHtml
                )
                ProfileBody(gitHubUser = uiState.gitHubUser)
                Followers(gitHubUser = uiState.gitHubUser)
            }
        }
    }
}

@Composable
fun ProfileAvatar(modifier: Modifier = Modifier, avatarUrl: String, statusEmojiHtml: String) {
    Box {
        AsyncImage(
            model = avatarUrl,
            contentDescription = stringResource(id = R.string.content_description_profile_avatar),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(contentWidth)
                .clip(CircleShape)
                .background(MaterialTheme.customColorsPalette.avatarBackground)
                .border(
                    BorderStroke(2.dp, MaterialTheme.customColorsPalette.avatarBorder),
                    CircleShape
                )
        )

        Box(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(vertical = 20.dp)
        ) {
            Box(
                modifier = modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.customColorsPalette.profileStatusBackground)
                    .border(
                        BorderStroke(2.dp, MaterialTheme.customColorsPalette.profileStatusBorder),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = modifier
                        .size(24.dp)
                        .wrapContentSize(),
                    text = buildAnnotatedString {
                        append(HtmlCompat.fromHtml(statusEmojiHtml, 0))
                    },
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun ProfileBody(modifier: Modifier = Modifier, gitHubUser: GitHubUser) {
    Row(modifier = modifier.width(contentWidth).wrapContentHeight().padding(top = 8.dp)) {
        Column {
            Text(
                modifier = modifier,
                text = gitHubUser.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                modifier = modifier,
                text = gitHubUser.login,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                modifier = modifier.padding(top = 8.dp),
                text = gitHubUser.bio,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun Followers(modifier: Modifier = Modifier, gitHubUser: GitHubUser) {
    Row(modifier = modifier.width(contentWidth).wrapContentHeight().padding(top = 8.dp)) {
        Column(modifier = modifier) {
            Text(
                modifier = modifier,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(gitHubUser.followersCount.toString())
                    }
                    append(" ${stringResource(id = R.string.followers)}")
                },
            )
        }
        Column(modifier = modifier.padding(start = 8.dp)) {
            Text(
                modifier = modifier,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(gitHubUser.followingCount.toString())
                    }
                    append(" ${stringResource(id = R.string.following)}")
                },
            )
        }
    }
}

@Preview(widthDp = 320, heightDp = 320)
@Composable
fun ProfileScreenLoadingPreview() {
    DroidHubTheme {
        ProfileScreen(modifier = Modifier.fillMaxSize(), uiState = ProfileUiState(isLoading = true))
    }
}

@Preview(showSystemUi = true)
@Composable
fun ProfileScreenUserPreview() {
    val user = GitHubUser(
        login = "vgaidarji",
        id = 3036347,
        avatarUrl = "https://avatars.githubusercontent.com/u/3036347?v=4",
        url = "https://api.github.com/users/vgaidarji",
        starredUrl = "https://api.github.com/users/vgaidarji/starred{/owner}{/repo}",
        reposUrl = "https://api.github.com/users/vgaidarji/repos",
        name = "Veaceslav Gaidarji",
        company = "",
        blog = "http://vgaidarji.me",
        location = "Moldova",
        email = "",
        bio = "CTO @Orangesoft-Development | ex-Director of Engineering @crunchyroll",
        publicRepositoriesCount = 69,
        followersCount = 105,
        followingCount = 104
    )

    val userStatus = GitHubUserStatus(
        emoji = "",
        emojiHtml = "<div>\uD83D\uDE80</div>", // 🚀
        expiresAt = "",
        limitedAvailability = "",
        message = ""
    )

    DroidHubTheme {
        ProfileScreen(
            modifier = Modifier.fillMaxSize(),
            uiState = ProfileUiState(user, userStatus, isLoading = false)
        )
    }
}

