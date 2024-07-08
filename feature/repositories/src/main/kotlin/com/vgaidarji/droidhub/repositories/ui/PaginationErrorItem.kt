package com.vgaidarji.droidhub.repositories.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PaginationErrorItem(
    modifier: Modifier = Modifier,
    onTryAgainClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = modifier,
            onClick = onTryAgainClick
        ) {
            Text(text = "Try Again")
        }
    }
}
