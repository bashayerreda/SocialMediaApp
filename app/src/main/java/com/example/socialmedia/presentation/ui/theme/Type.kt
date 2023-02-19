package com.example.socialmedia.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.socialmedia.R

// Set of Material typography styles to start with
val quickSandFont  = FontFamily(Font(R.font.quicksand_bold,FontWeight.Bold),
            Font(R.font.quicksand_semibold,FontWeight.SemiBold),
            Font(R.font.quicksand_light,FontWeight.Light),
            Font(R.font.quicksand_medium,FontWeight.Medium),
            Font(R.font.quicksand_regular,FontWeight.Normal),
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = quickSandFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        color = TextWhite


    ),
    h2 = TextStyle(
        fontFamily = quickSandFont,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    body2 = TextStyle(
        fontFamily = quickSandFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = TextWhite
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)