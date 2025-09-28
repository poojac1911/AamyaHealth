package com.example.aamyahealth.data

import androidx.compose.ui.graphics.painter.Painter

data class BottomBarNavItem(
    val title: String,
    val route: String,
    val icon: Painter,
    val isSelected: Boolean
)
