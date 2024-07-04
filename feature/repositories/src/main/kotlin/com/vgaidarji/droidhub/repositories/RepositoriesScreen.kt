package com.vgaidarji.droidhub.repositories

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vgaidarji.droidhub.base.ui.component.ProgressView

@Composable
fun RepositoriesScreen(modifier: Modifier = Modifier, repositoriesViewModel: RepositoriesViewModel) {
    val uiState by repositoriesViewModel.uiState.collectAsStateWithLifecycle()

    RepositoriesScreen(modifier, uiState)
}

@Composable
fun RepositoriesScreen(modifier: Modifier = Modifier, uiState: RepositoriesUiState) {
    if (uiState.isLoading) {
        ProgressView()
    } else {
        Surface(modifier, color = MaterialTheme.colorScheme.background) {

        }
    }
}
