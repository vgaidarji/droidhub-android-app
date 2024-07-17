package com.vgaidarji.droidhub.base.ui.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

/**
 * Composable which updates system bar colors ("status" is top and "navigation" is bottom)
 * It's useful when need to match the colors of the screen elements.
 */
@Composable
fun SystemBarColors(
    statusBarLight: Color = MaterialTheme.colorScheme.background,
    statusBarDark: Color = MaterialTheme.colorScheme.background,
    navigationBarLight: Color = MaterialTheme.colorScheme.background,
    navigationBarDark: Color = MaterialTheme.colorScheme.background,
) {
    val isDarkMode = isSystemInDarkTheme()
    val context = LocalContext.current as ComponentActivity

    DisposableEffect(isDarkMode) {
        context.enableEdgeToEdge(
            statusBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    statusBarLight.toArgb(),
                    statusBarDark.toArgb()
                )
            } else {
                SystemBarStyle.dark(
                    statusBarDark.toArgb()
                )
            },
            navigationBarStyle = if (!isDarkMode) {
                SystemBarStyle.light(
                    navigationBarLight.toArgb(),
                    navigationBarDark.toArgb()
                )
            } else {
                SystemBarStyle.dark(navigationBarDark.toArgb())
            }
        )
        onDispose { }
    }
}