package com.example.socialmedia.presentation.ui.splashscreen

import android.window.SplashScreen
import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.socialmedia.MainActivity
import com.example.socialmedia.presentation.ui.theme.SocialMediaTheme
import com.example.socialmedia.presentation.util.Constants
import com.example.socialmedia.presentation.util.Screens
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
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
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun splashScreen_displaysAndDisappears() =  runTest(testDispatcher)  {
        composeTestRule.activity.setContent {
            SocialMediaTheme {
                splashScreen(
                    navController = navController,
                    dispatcher = testDispatcher
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("logo")
            .assertExists()
       testDispatcher.scheduler.advanceUntilIdle()
        verify {
            navController.popBackStack()
            navController.navigate(Screens.LoginScreen.route)
        }
    }
}