package com.example.aamyahealth.ui.navigation

import com.example.aamyahealth.R

interface NavigationDestination {
    val route: String
    val titleRes: Int
}


object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.home
}

object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val titleRes = R.string.profile
}

object MessagesDestination : NavigationDestination {
    override val route = "messages"
    override val titleRes = R.string.message
}

object AppointmentDestination : NavigationDestination {
    override val route = "appointment"
    override val titleRes = R.string.appointment
}