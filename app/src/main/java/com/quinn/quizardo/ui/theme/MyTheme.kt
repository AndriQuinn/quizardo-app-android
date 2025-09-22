package com.quinn.quizardo.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object MyTheme {
    val header1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        fontFamily = FontFamily.SansSerif
    )

    val header2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        fontFamily = FontFamily.SansSerif
    )

    val header3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 25.sp,
        fontFamily = FontFamily.SansSerif
    )
}