package com.example.aamyahealth.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aamyahealth.R
import com.example.aamyahealth.data.BottomBarNavItem
import com.example.aamyahealth.ui.navigation.AamyaHealthNavHost

@Preview
@Composable
fun AamyaHealthApp (){

    val navController = rememberNavController()
    val bottomBarNavItems = listOf(
        BottomBarNavItem(
            title = "Home",
            route = "home",
            icon = painterResource(R.drawable.home),
            isSelected = true
        ),
        BottomBarNavItem(
            title = "Messages",
            route = "messages",
            icon = painterResource(R.drawable.message),
            isSelected = false
        ),
        BottomBarNavItem(
            title = "Appointment",
            route = "appointment",
            icon =  painterResource(R.drawable.schedule),
            isSelected = false
        ),
        BottomBarNavItem(
            title = "Profile",
            route = "profile",
            icon = painterResource(R.drawable.profile),
            isSelected = false
        ),
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.onPrimary) {
                bottomBarNavItems.forEach { navItem ->
                    NavigationBarItem(
                        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(20.dp)),
                        selected = currentRoute == navItem.route,
                        onClick = {
                            navController.navigate(navItem.route){
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Image(
                                modifier = Modifier,
                                painter = navItem.icon,
                                contentDescription = null,
                                colorFilter = if (navItem.isSelected){
                                    ColorFilter.tint(Color.Black)
                                } else {
                                    ColorFilter.tint(Color.Gray)
                                }
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Unspecified,
                            unselectedIconColor = Color.Unspecified,
                            indicatorColor = Color(0xFFFFBC00)
                        ),
                    )
                }
            }
        },
    ) { innerPadding ->
        Surface (Modifier.padding(innerPadding),
                color = MaterialTheme.colorScheme.background
        ){
            AamyaHealthNavHost(navController,modifier = Modifier)
        }
    }
}