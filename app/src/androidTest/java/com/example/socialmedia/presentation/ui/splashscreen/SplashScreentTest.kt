package com.example.socialmedia.presentation.ui.splashscreen

import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import org.junit.Assert.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.socialmedia.MainActivity
import androidx.test.runner.AndroidJUnitRunner
import com.example.socialmedia.presentation.ui.theme.SocialMediaTheme
import com.example.socialmedia.presentation.util.Screens
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreentTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @RelaxedMockK
    lateinit var navController: NavController

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    //for feature update
   /* @Test
    fun checkSplashScreenWork() = runBlockingTest {
        composeTestRule.setContent {
            SocialMediaThegit initme {
                splashScreen(
                    navController = navController,
                    //dispatcher = testDispatcher
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()

        // advanceTimeBy(Constants.SPLASH_SCREEN_DURATION)

        verify {
            navController.popBackStack()
            navController.navigate(Screens.LoginScreen.route)
        }
    }*/

    @Test
    fun checkSplashScreenWork2() {
        composeTestRule.activity.setContent {

            SocialMediaTheme {
                splashScreen(
                    navController = navController
                )
            }
        }


        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()
    }

}