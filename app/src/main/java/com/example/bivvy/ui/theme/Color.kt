package com.example.bivvy.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


//тема приложения
val blackbox = Color(0xFF000000)
val bluebox = Color(0xFF002766)

val AppGradient =  Brush.linearGradient(
    colors = listOf(bluebox, blackbox, bluebox),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)

val GlassEdge = Brush.linearGradient(
    colors = listOf(
        Color.White.copy(alpha = 0.55f),   // яркий угол сверху слева
        Color.White.copy(alpha = 0.05f),   // почти пропадает в середине
        Color.White.copy(alpha = 0.25f)    // слабый блик снизу справа
    ),
    start = Offset(0f, 0f),
    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
)

val GlassFill = Brush.verticalGradient(
    listOf(Color.White.copy(alpha = 0.18f), Color.White.copy(alpha = 0.05f))
)