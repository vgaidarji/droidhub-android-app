package com.vgaidarji.droidhub.contributions.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EmptyCell() {
    Box(
        modifier = Modifier
            .padding(end = 2.dp)
            .background(Color.Transparent)
            .size(28.dp)
    )
}
