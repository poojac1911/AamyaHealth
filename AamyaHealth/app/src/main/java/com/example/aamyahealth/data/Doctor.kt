package com.example.aamyahealth.data

data class Doctor(
    val id: Int,
    val name: String,
    val speciality: String,
    val imageRes: Int,
    val rating: Double,
    val color: androidx.compose.ui.graphics.Color,
)
