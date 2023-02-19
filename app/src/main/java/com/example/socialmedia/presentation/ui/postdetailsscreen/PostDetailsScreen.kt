package com.example.socialmedia.presentation.ui.postdetailsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.socialmedia.domain.models.Comments
import com.example.socialmedia.domain.models.Post
import com.example.socialmedia.presentation.util.sharedcomposables.StandardToolBar

@Composable
fun PostDetailsScreen(post: Post,navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolBar(
            navController = navController, modifier = Modifier,
            title = { Text(text = "Your Feeds") },
            showBackArrow = true
        )
        detailsPosts(post = post)


    }
}