package com.example.aamyahealth.ui.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.aamyahealth.R

@Composable
fun SearchBarTextFieldComponent(
    modifier: Modifier = Modifier,
    search: String,
    onSearchChange: (String) -> Unit
) {
    OutlinedTextField(
        value = search,
        onValueChange = onSearchChange,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.onSecondary,
            unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        shape = RoundedCornerShape(36.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(36.dp), clip = true)
    )
}