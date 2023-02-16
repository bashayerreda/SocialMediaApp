package com.example.socialmedia.presentation.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Message
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.socialmedia.presentation.util.sharedcomposables.StandardNavigationButtonItems

@Composable
fun StandardScaffold(content : @Composable () -> Unit) {
     Scaffold(
         bottomBar = {
                 BottomAppBar(
                     modifier = Modifier.fillMaxWidth(),
                     backgroundColor = Color.LightGray,
                     cutoutShape = CircleShape,
                     elevation = 5.dp
                 ) {
                     BottomNavigation(modifier = Modifier.fillMaxWidth()) {
                          StandardNavigationButtonItems(onClick = {}, icon = Icons.Outlined.Message,
                              contentDescription = "Message")
                     }

                 }
         }
     ) {
      content()
     }
}