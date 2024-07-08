package com.vgaidarji.droidhub.repositories.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PaginationRetryItem(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterHorizontally)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onRetryClick
                ),
            imageVector = Icons.Rounded.Refresh,
            contentDescription = null
        )
    }
}
