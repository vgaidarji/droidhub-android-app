package com.vgaidarji.droidhub.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vgaidarji.droidhub.base.ui.PreviewWithBackground
import com.vgaidarji.droidhub.base.ui.component.ProgressView
import com.vgaidarji.droidhub.base.ui.theme.DroidHubTheme

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    splashViewModel: SplashViewModel = hiltViewModel(),
    onNavigateToHomeScreen: () -> Unit
) {
    val uiState by splashViewModel.uiState.collectAsStateWithLifecycle()
    SplashScreen(modifier, uiState, onNavigateToHomeScreen = onNavigateToHomeScreen)
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier, uiState: SplashUiState, onNavigateToHomeScreen: () -> Unit ) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.isLoading) {
            ProgressView()
        } else {
            onNavigateToHomeScreen()
        }
    }
}

@PreviewWithBackground
@Composable
fun SplashScreenPreview() {
    DroidHubTheme {
        SplashScreen(modifier = Modifier.fillMaxSize(), uiState = SplashUiState(), {})
    }
}
