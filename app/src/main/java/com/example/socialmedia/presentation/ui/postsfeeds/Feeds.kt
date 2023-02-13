package com.example.socialmedia.presentation.ui.postsfeeds

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.socialmedia.domain.models.Post

@Composable
fun Feeds(navController: NavController){
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