package com.jarvis.client.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = ArcBlue,
    onPrimary = DeepNavy,
    secondary = SoftCyan,
    onSecondary = DeepNavy,
    background = DarkGray,
    onBackground = TextGray,
    surface = DeepNavy,
    onSurface = SoftCyan,
    error = ErrorRed,
    onError = Color.Black
)

@Composable
fun JarvisTheme(
    darkTheme: Boolean = true, // We force dark theme for Jarvis
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
