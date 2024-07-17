package com.vgaidarji.droidhub.repositories.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vgaidarji.droidhub.base.ui.component.ProgressView

@Composable
fun PaginationLoadingItem(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        ProgressView()
    }
}
