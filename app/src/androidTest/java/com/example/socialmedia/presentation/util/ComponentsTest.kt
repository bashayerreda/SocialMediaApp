package com.example.socialmedia.presentation.util

import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.socialmedia.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ComponentsTest
{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        composeTestRule.activity.setContent {
            var text by remember {
                mutableStateOf("")
            }
            MaterialTheme {
                InputText(text = text, onValueChanged = {
                             text = it
                },
                    maxSize = 5,
                    modifier = Modifier.semantics {
                        testTag = Constants.STANDERED_TEXT_FIELD
                    }

                    )
            }
        }
    }

    @Test
    fun testTextInputDontTakeMoreThanMaxLength(){
        composeTestRule.onNodeWithTag(testTag = Constants.STANDERED_TEXT_FIELD)
              .performTextClearance()
          composeTestRule.onNodeWithTag(testTag = Constants.STANDERED_TEXT_FIELD)
              .performTextInput(Constants.stringForTesting)

        composeTestRule.onNodeWithTag(testTag = Constants.STANDERED_TEXT_FIELD)
            .assertTextEquals(Constants.stringForTesting)

    }
}