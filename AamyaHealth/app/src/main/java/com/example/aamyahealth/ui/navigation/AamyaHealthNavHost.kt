package com.example.aamyahealth.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aamyahealth.ui.presentation.screens.AppointmentScreen
import com.example.aamyahealth.ui.presentation.screens.HomeScreen
import com.example.aamyahealth.ui.presentation.screens.MessageScreen
import com.example.aamyahealth.ui.presentation.screens.ProfileScreen

@Composable
fun AamyaHealthNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(navController = navController)
        }
        composable(route = MessagesDestination.route) {
            MessageScreen(navController = navController)
        }
        composable(route = AppointmentDestination.route) {
            AppointmentScreen(navController = navController)
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(navController = navController)
        }
    }
}