package com.example.socialmedia.presentation.ui.postsfeeds

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.socialmedia.domain.models.Post
import com.example.socialmedia.presentation.util.StandardScaffold

@Composable
fun Feeds(navController: NavController){
    StandardScaffold {
        Posts(
            post = Post(
                userName = "bashayer R Mansour",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                        "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                        "magna aliquyam erat, sed diam voluptua...",
                likesCount = 7,
                commentsCount = 5,
                profilePictureUrl = "" ,
                imageUrl = ""
            ),
            onPostsClicked = {

            }
        )
    }


}