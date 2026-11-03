package com.example.onemorecofee
import androidx.annotation.DrawableRes

data class Cafe(
    val nome: String,
    val descricion: String,
    val intensidade: Int,
    @DrawableRes val imaxe: Int
)
