package com.vgaidarji.droidhub.splash

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vgaidarji.droidhub.api.BuildConfig
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme
import com.vgaidarji.droidhub.base.viewmodel.GitHubUserNameViewModel

@Composable
fun UserNameScreen(
    modifier: Modifier = Modifier,
    gitHubUserNameViewModel: GitHubUserNameViewModel = hiltViewModel(),
    onNavigateToHomeScreen: () -> Unit,
    onBack: () -> Unit
) {
    BackHandler {
        onBack()
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var userName by remember { mutableStateOf(BuildConfig.GITHUB_USER_NAME) }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = userName,
                onValueChange = { userName = it },
                label = { Text("github.com/") }
            )
            Button(modifier = Modifier.padding(start = 4.dp),
                onClick = {
                    gitHubUserNameViewModel.updateUser(userName)
                    onNavigateToHomeScreen()
                })
            {
                Text("GO")
            }
        }
    }
}

@PreviewWithBackground
@Composable
fun UserNameScreenPreview() {
    DroidHubTheme {
        UserNameScreen(modifier = Modifier.fillMaxSize(), GitHubUserNameViewModel(), {}, {})
    }
}
