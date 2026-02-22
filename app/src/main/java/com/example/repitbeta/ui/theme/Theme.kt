package com.example.repitbeta.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AppColors = darkColorScheme(
    primary = Color(0xFF6D5BD0),
    secondary = Color(0xFF8A7BF2),
    background = Color(0xFFF4F4F4)
)

@Composable
fun RepItBetaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColors,
        typography = MaterialTheme.typography,
        content = content
    )
}
