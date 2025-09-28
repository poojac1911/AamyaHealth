package com.example.aamyahealth.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aamyahealth.R
import com.example.aamyahealth.data.Appointment
import com.example.aamyahealth.data.DayItem
import com.example.aamyahealth.data.Doctor
import com.example.aamyahealth.data.Sector
import com.example.aamyahealth.ui.presentation.components.DoctorCardComponent
import com.example.aamyahealth.ui.presentation.components.IconButtonComponent
import com.example.aamyahealth.ui.presentation.components.SearchBarTextFieldComponent
import com.example.aamyahealth.ui.presentation.components.TitleCardComponent
import com.example.aamyahealth.ui.presentation.components.TypeCardComponent
import com.example.aamyahealth.ui.presentation.components.UpcomingAppointmentCardComponent
import com.example.aamyahealth.ui.presentation.components.WeekCardComponent
import com.example.aamyahealth.ui.presentation.components.WeekDayCardComponent

@Composable
fun HomeScreen(navController: NavHostController = rememberNavController()) {

    val doctorList = listOf(
        Doctor(1, "Dr. Ralph Edward", "Dentist Specialist", R.drawable.avatar_doctor_1,4.8, color = MaterialTheme.colorScheme.surfaceVariant),
        Doctor(2, "Dr. Bessie Cooper", "Surgery Specialist", R.drawable.avatar_doctor_2,4.6,MaterialTheme.colorScheme.secondaryContainer),
        Doctor(3, "Dr. Annette Black", "Urology Specialist", R.drawable.avatar_doctor_3,4.2,MaterialTheme.colorScheme.inversePrimary),
        Doctor(4, "Dr. Lailas Russell", "Dermatologist", R.drawable.avatar_doctor_1,4.5,MaterialTheme.colorScheme.secondaryContainer)
    )
    val weekDays = listOf(
        DayItem("Sun", 15),
        DayItem("Mon", 16),
        DayItem("Tue", 17),
        DayItem("Wed", 18),
        DayItem("Thu", 19),
        DayItem("Fri", 20),
        DayItem("Sat", 21)
    )
    var selectedDay by remember { mutableStateOf(weekDays[0].day) }

    val sector = listOf(
        Sector("Hospital", color = MaterialTheme.colorScheme.inversePrimary, painterResource(R.drawable.type_hospital)),
        Sector("Consultation", color = MaterialTheme.colorScheme.inverseOnSurface, painterResource(R.drawable.type_consultation)),
        Sector("Consultation", color = MaterialTheme.colorScheme.secondaryContainer, painterResource(R.drawable.type_brain)),
        Sector("Dental", color = MaterialTheme.colorScheme.inversePrimary, painterResource(R.drawable.type_dental)),
    )
    val upcomingSchedules = listOf(
        Appointment("Dr. Lailas Russell", "Dermatologist Specialist", "20 September - 12:30 - 10:30 PM", R.drawable.avatar_doctor_2),
        Appointment("Dr. Cries Jacks", "Cardiologist Specialist", "22 September - 2:00 - 3:00 PM", R.drawable.avatar_doctor_3),
    )
    var search by remember { mutableStateOf("") }

    Surface (
        Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        LazyColumn (
            modifier = Modifier,
            verticalArrangement = Arrangement.Top,
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar_user),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    IconButtonComponent(
                        modifier = Modifier
                            .size(46.dp)
                            .shadow(4.dp, CircleShape),
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White,
                        ),
                        onClick = { /* do something */ },
                        icon = Icons.Outlined.Notifications,
                    )
                }
                SearchBarTextFieldComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                    search = search,
                    onSearchChange = { search = it }
                )
            }

            item {
                WeekDayCardComponent(
                    modifier = Modifier.padding(12.dp),
                    content = {
                        LazyRow(
                            Modifier.padding(top = 12.dp, bottom = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(
                                items = weekDays
                            ) {
                                val paddingValues = when (it) {
                                    weekDays.first() -> {
                                        PaddingValues(start = 12.dp)
                                    }
                                    weekDays.last() -> {
                                        PaddingValues(end = 12.dp)
                                    }
                                    else -> {
                                        PaddingValues(start = 0.dp, end = 0.dp)
                                    }
                                }

                                WeekCardComponent(
                                    modifier = Modifier.padding(paddingValues),
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (it.day == selectedDay) Color(0xFFFFBC00) else Color.White,
                                        contentColor = if (it.day == selectedDay) Color.White else Color.Black.copy(alpha = 0.6f),
                                    ),
                                    onDaySelected = {
                                        selectedDay = it.day
                                    },
                                    day = it.day,
                                    date = it.date.toString()
                                )
                            }
                        }
                        LazyRow(
                            Modifier.padding(top = 12.dp, bottom = 12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            items(
                                items = doctorList
                            ){doctorItem ->
                                val paddingValues = when (doctorItem) {
                                    doctorList.first() -> {
                                        PaddingValues(start = 12.dp)
                                    }
                                    doctorList.last() -> {
                                        PaddingValues(end = 12.dp)
                                    }
                                    else -> {
                                        PaddingValues(start = 0.dp, end = 0.dp)
                                    }
                                }
                                DoctorCardComponent(
                                    modifier = Modifier
                                        .padding(paddingValues)
                                        .size(110.dp, 100.dp),
                                    doctorImage = doctorItem.imageRes,
                                    doctorName = doctorItem.name,
                                    doctorSpeciality = doctorItem.speciality,
                                    rating = doctorItem.rating.toString(),
                                    colors = CardDefaults.cardColors(
                                        containerColor = doctorItem.color,
                                        contentColor = Color.Black,
                                    )
                                )
                            }
                        }
                    }
                )
            }

            item {
                LazyRow(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = sector
                    ) {
                        val paddingValues = when (it) {
                            sector.first() -> {
                                PaddingValues(start = 12.dp, top = 12.dp)
                            }
                            sector.last() -> {
                                PaddingValues(end = 12.dp, top = 12.dp)
                            }
                            else -> {
                                PaddingValues(start = 0.dp, end = 0.dp, top = 12.dp)
                            }
                        }
                        TypeCardComponent(
                            modifier = Modifier.padding(paddingValues),
                            title = it.name,
                            color = it.color,
                            icon = it.icon
                        )
                    }
                }
            }
            item {
                TitleCardComponent(
                    modifier = Modifier
                        .padding(start = 12.dp, top = 12.dp, end = 12.dp)
                        .fillMaxWidth(),
                    title = "Upcoming Schedules"
                )
            }
            items(
                items = upcomingSchedules
            ){
                val paddingValues = PaddingValues(start = 12.dp, end = 12.dp, bottom = 12.dp)

                UpcomingAppointmentCardComponent(
                    modifier = Modifier.padding(paddingValues),
                    image = painterResource(it.doctorImage),
                    doctorName = it.doctorName,
                    doctorSpeciality = it.specialization,
                    scheduleTime = it.dateTime
                )
            }
        }
    }
}