package com.example.socialmedia.presentation.util

import android.provider.ContactsContract
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialmedia.ActivityScreen
import com.example.socialmedia.Messages
import com.example.socialmedia.Profile
import com.example.socialmedia.presentation.ui.registerscreen.registerScreen
import com.example.socialmedia.presentation.ui.loginscreen.logInScreen
import com.example.socialmedia.presentation.ui.postsfeeds.Feeds
import com.example.socialmedia.presentation.ui.splashscreen.splashScreen

@Composable
fun navigation(navController: NavHostController) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(Screens.SplashScreen.route) {
            splashScreen(navController = navController)
        }
        composable(Screens.LoginScreen.route) {
            logInScreen(navController = navController)
        }
        composable(Screens.RegisterScreen.route) {
            registerScreen(navController = navController)
        }
        composable(Screens.MainFeedScreen.route) {
            Feeds(navController = navController)
        }
        composable(Screens.MessagesScreen.route) {
            Messages(navController = navController)
        }
        composable(Screens.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screens.ProfileScreen.route) {
            Profile(navController = navController)
        }


    }
}