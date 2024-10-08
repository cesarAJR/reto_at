package com.cesar.reto_apuesta_total.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cesar.reto_apuesta_total.presentation.history.HistoryScreen
import com.cesar.reto_apuesta_total.presentation.login.LoginScreen

@Composable
fun SetupNavGraph(navController: NavHostController,isLogged : Boolean) {
    val startDestination =  if(isLogged){
        Screen.History.route}else{
        Screen.Login.route}

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            route = Screen.Login.route,
        ) {
            BackHandler(true) {
            }
            LoginScreen(
                onHistory = {
                    navController.navigate(Screen.History.route)
                }
            )
        }

        composable(
            route = Screen.History.route,
        ) {
            BackHandler(true) {
            }
            HistoryScreen(
                onLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
    }
}