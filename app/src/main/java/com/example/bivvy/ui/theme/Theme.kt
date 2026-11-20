package com.example.bivvy.ui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

// Дизайн рассчитан только на тёмный градиент: схему фиксируем тёмной,
// динамические цвета (из обоев) и светлую тему не используем.
private val BivvyColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = bluebox,
    background = blackbox,
    onBackground = Color.White,
    surface = blackbox,
    onSurface = Color.White
)

@Composable
fun BivvyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = BivvyColorScheme,
        typography = Typography
    ) {
        // Цвет текста по умолчанию для всего приложения: Text без параметра color будет белым
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            content()
        }
    }
}