package com.example.aamyahealth.ui.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector = Icons.Default.Home,
    tint: Color = Color.Unspecified,
    colors : IconButtonColors = IconButtonDefaults.iconButtonColors(),
    enabled: Boolean = true
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enabled,
    ) {
        Icon(
            imageVector = icon,
            modifier = Modifier,
            tint = tint,
            contentDescription = null
        )
    }
}

@Composable
fun ImageButtonComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: Painter,
    tint: Color = Color.Unspecified,
    colors : IconButtonColors = IconButtonDefaults.iconButtonColors(),
    enabled: Boolean = true
) {
    IconButton(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        enabled = enabled
    ) {
        Icon(
            icon,
            modifier = Modifier,
            tint = tint,
            contentDescription = null
        )
    }
}