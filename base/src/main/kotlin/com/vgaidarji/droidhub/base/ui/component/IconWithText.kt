package com.vgaidarji.droidhub.base.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun IconWithText(
    modifier: Modifier = Modifier,
    @DrawableRes iconDrawableRes: Int,
    @StringRes contentDescriptionRes: Int,
    text: String,
    color: Color = Color.DarkGray
) {
    Row(modifier = modifier.wrapContentHeight()) {
        Column(modifier = modifier) {
            Row {
                Image(
                    modifier = modifier.size(16.dp),
                    painter = painterResource(id = iconDrawableRes),
                    contentDescription = stringResource(id = contentDescriptionRes)
                )
                Text(
                    modifier = modifier.padding(start = 4.dp),
                    text = text,
                    style = MaterialTheme.typography.labelMedium,
                    color = color
                )
            }
        }
    }
}