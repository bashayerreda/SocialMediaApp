package com.example.socialmedia.presentation.ui.postsfeeds

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.socialmedia.domain.models.Post
import com.example.socialmedia.presentation.util.StandardScaffold
import com.example.socialmedia.presentation.util.sharedcomposables.StandardToolBar
import com.example.socialmedia.R
import com.example.socialmedia.presentation.util.Screens

@Composable
fun Feeds(navController: NavController){
    Column(Modifier.fillMaxWidth()) {
        StandardToolBar(navController = navController, title = {
            Text(text = "Your Feeds")
        }, modifier = Modifier, showBackArrow = false, navAction = {
            IconButton(onClick = {
                navController.navigate(Screens.PostDetailsScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(id = R.string.searchForItem),
                    tint = MaterialTheme.colors.onBackground
                )
            }

        })
        Posts(
            post = Post(
                userName = "bashayer R Mansour",
                description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                        "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                        "magna aliquyam erat, sed diam voluptua...",
                likesCount = 7,
                commentsCount = 5,
                profilePictureUrl = "",
                imageUrl = ""
            ),
            onPostsClicked = {
                 navController.navigate(Screens.PostDetailsScreen.route)
            }
        )
    }




}