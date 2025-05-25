package com.example.planetfacts

data class Planet(
    val name: String,
    val imageResId: Int,
    val facts: List<String>
)