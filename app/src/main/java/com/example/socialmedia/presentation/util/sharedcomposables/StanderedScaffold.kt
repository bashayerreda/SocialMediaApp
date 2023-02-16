package com.example.socialmedia.presentation.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.socialmedia.R
import com.example.socialmedia.presentation.ui.theme.HintGray
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

                          StandardNavigationButtonItems(onClick = {}, icon = Icons.Outlined.House,
                              contentDescription = stringResource(id = R.string.House), selectedColor = MaterialTheme.colors.primary, unSelectedColor = HintGray, enabled = true, isSelected = true)

                         StandardNavigationButtonItems(onClick = {}, icon = Icons.Outlined.Message,
                             contentDescription =stringResource(id = R.string.Message), selectedColor = MaterialTheme.colors.primary, unSelectedColor = HintGray, enabled = true, isSelected = true, countNum = 50)


                         StandardNavigationButtonItems(onClick = {}, icon = Icons.Outlined.Notifications,
                             contentDescription = stringResource(id = R.string.Activity), selectedColor = MaterialTheme.colors.primary, unSelectedColor = HintGray, enabled = true, isSelected = true)


                         StandardNavigationButtonItems(onClick = {}, icon = Icons.Outlined.Person,
                             contentDescription = stringResource(id = R.string.Person), selectedColor = MaterialTheme.colors.primary, unSelectedColor = HintGray, enabled = true, isSelected = true, countNum = 10)
                     }

                 }
         }
     ) {
      content()
     }
}