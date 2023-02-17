package com.example.socialmedia.presentation.util.sharedcomposables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.TopAppBar
import com.example.socialmedia.R
@Composable
fun StandardToolBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    title : @Composable () -> Unit = {},
    showBackArrow : Boolean = true,
    navAction : @Composable RowScope.() -> Unit = {}
) {
     TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = { if(showBackArrow){
            IconButton(onClick = { navController.navigateUp() }) {
              Icon(imageVector = Icons.Default.ArrowBack,
                  contentDescription = stringResource(id = R.string.back),
              tint = MaterialTheme.colors.onBackground)
            }
        }else null

        },
        actions = navAction,
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp
    )
}