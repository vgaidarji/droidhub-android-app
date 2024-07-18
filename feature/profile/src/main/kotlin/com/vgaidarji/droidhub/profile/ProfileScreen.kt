package com.vgaidarji.droidhub.profile

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.vgaidarji.droidhub.api.BuildConfig
import com.vgaidarji.droidhub.base.ui.component.IconWithText
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.ui.theme.customColorsPalette
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import java.time.LocalDateTime
import com.vgaidarji.droidhub.base.R as RBase

val contentWidth = 300.dp

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    gitHubUserName: String = BuildConfig.GITHUB_USER_NAME,
    onBack: () -> Unit
) {
    val profileViewModel: ProfileViewModel = hiltViewModel<ProfileViewModel, ProfileViewModel.ProfileViewModelFactory> { factory ->
        factory.create(gitHubUserName)
    }
    val uiState by profileViewModel.uiState.collectAsStateWithLifecycle()
    BackHandler {
        onBack()
    }
    ProfileScreen(modifier, uiState)
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier, uiState: ProfileUiState) {
    if (uiState.isLoading) {
        ProgressView()
    } else {
        Surface(modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
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
                Location(location = uiState.gitHubUser.location)
                Email(email = uiState.gitHubUser.email)
                Blog(blogUrl = uiState.gitHubUser.blog)
                TwitterUserName(twitterUserName = uiState.gitHubUser.twitterUserName)
            }
        }
    }
}

@Composable
fun Location(modifier: Modifier = Modifier, location: String) {
    Row(modifier = modifier
        .width(contentWidth)
        .wrapContentHeight().padding(top = 8.dp)) {
        IconWithText(
            iconDrawableRes = RBase.drawable.ic_octicons_location,
            contentDescriptionRes = RBase.string.content_description_location,
            text = location
        )
    }
}

@Composable
fun Email(modifier: Modifier = Modifier, email: String) {
    Row(modifier = modifier
        .width(contentWidth)
        .padding(top = 5.dp)
        .wrapContentHeight()) {
        IconWithText(
            iconDrawableRes = RBase.drawable.ic_octicons_email,
            contentDescriptionRes = RBase.string.content_description_email,
            text = email
        )
    }
}

@Composable
fun Blog(modifier: Modifier = Modifier, blogUrl: String) {
    Row(modifier = modifier
        .width(contentWidth)
        .padding(top = 5.dp)
        .wrapContentHeight()) {
        IconWithText(
            iconDrawableRes = RBase.drawable.ic_octicons_link,
            contentDescriptionRes = RBase.string.content_description_blog_url,
            text = blogUrl
        )
    }
}

@Composable
fun TwitterUserName(modifier: Modifier = Modifier, twitterUserName: String) {
    Row(modifier = modifier
        .width(contentWidth)
        .padding(top = 5.dp)
        .wrapContentHeight()) {
        IconWithText(
            iconDrawableRes = RBase.drawable.ic_octicons_twitter,
            contentDescriptionRes = RBase.string.content_description_blog_url,
            text = "@${twitterUserName}"
        )
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
                .padding(vertical = 34.dp)
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
    Row(modifier = modifier
        .width(contentWidth)
        .wrapContentHeight()
        .padding(top = 8.dp)) {
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
    Row(modifier = modifier
        .width(contentWidth)
        .wrapContentHeight()
        .padding(top = 8.dp)) {
        Column(modifier = modifier) {
            Row {
                Image(
                    modifier = modifier.size(16.dp),
                    painter = painterResource(id = RBase.drawable.ic_octicons_people),
                    contentDescription = stringResource(id = RBase.string.content_description_followers)
                )
                FollowersText(modifier.padding(start = 4.dp), gitHubUser.followersCount, stringResource(id = R.string.followers))
            }
        }
        Column(modifier = modifier.padding(start = 8.dp)) {
            FollowersText(modifier, gitHubUser.followingCount, stringResource(id = R.string.following))
        }
    }
}

@Composable
private fun FollowersText(
    modifier: Modifier,
    count: Int,
    title: String
) {
    Text(
        modifier = modifier,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                append(count.toString())
            }
            append(" $title")
        },
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.secondary
    )
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
        email = "veaceslav.gaidarji@gmail.com",
        bio = "CTO @Orangesoft-Development | ex-Director of Engineering @crunchyroll",
        twitterUserName = "v_gaidarji",
        publicRepositoriesCount = 69,
        followersCount = 105,
        followingCount = 104,
        createdAt = LocalDateTime.of(2012, 12, 13, 18, 53, 49) //2012-12-13T18:53:49Z
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

