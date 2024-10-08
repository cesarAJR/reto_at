package com.cesar.reto_apuesta_total.presentation.navigation

sealed class Screen(val route:String) {
    object Login: Screen("login_screen")
    object History: Screen("history_screen")
}