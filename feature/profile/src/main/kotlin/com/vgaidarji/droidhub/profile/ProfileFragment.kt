package com.vgaidarji.droidhub.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.model.GitHubUser
import com.vgaidarji.droidhub.model.GitHubUserStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                DroidHubTheme {
                    ProfileScreen(modifier = Modifier.fillMaxSize(), profileViewModel)
                }
            }
        }
    }
}

@Preview (widthDp = 320, heightDp = 320)
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
        login = "",
        id = 1,
        avatarUrl = "",
        url = "",
        starredUrl = "",
        reposUrl = "",
        name = "Veaceslav Gaidarji",
        company = "",
        blog = "",
        location = "",
        email = "",
        bio = "",
        publicRepositoriesCount = 0,
        followersCount = 0,
        followingCount = 0
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