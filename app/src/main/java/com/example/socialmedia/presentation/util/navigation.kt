package com.example.socialmedia.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialmedia.presentation.ui.loginscreen.logInScreen
import com.example.socialmedia.presentation.ui.splashscreen.splashScreen

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            splashScreen(navController = navController)
        }
        composable(Screens.LoginScreen.route) {
            logInScreen(navController = navController)
        }
    }
}