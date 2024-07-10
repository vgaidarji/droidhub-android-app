package com.vgaidarji.droidhub.contributions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ContributionsScreen(modifier: Modifier = Modifier, contributionsViewModel:  ContributionsViewModel) {
    val uiState by contributionsViewModel.uiState.collectAsStateWithLifecycle()
}


