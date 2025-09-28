package com.example.aamyahealth.ui.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen (navController: NavHostController = rememberNavController()){
    Surface (
        Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = "Profile",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 18.sp
            )
        }
    }
}