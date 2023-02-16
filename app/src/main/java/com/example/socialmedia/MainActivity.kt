package com.example.socialmedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.socialmedia.presentation.ui.theme.SocialMediaTheme
import com.example.socialmedia.presentation.util.Screens
import com.example.socialmedia.presentation.util.StandardScaffold
import com.example.socialmedia.presentation.util.navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
   // @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialMediaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,


                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    StandardScaffold(
                        navController = navController,
                        showButtonBar = navBackStackEntry?.destination?.route in listOf(
                            Screens.MainFeedScreen.route,
                            Screens.ChatScreen.route,
                            Screens.ActivityScreen.route,
                            Screens.ProfileScreen.route,
                        ),
                        modifier = Modifier.fillMaxSize(),
                        )
                   navigation(navController = navController)
                    }
                }
            }
        }
    }


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")//,color = Color.Blue)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SocialMediaTheme {
        Greeting("Android")
    }
}