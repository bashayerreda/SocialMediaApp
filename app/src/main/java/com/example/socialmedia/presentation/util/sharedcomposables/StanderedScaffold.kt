package com.example.socialmedia.presentation.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.House
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.socialmedia.domain.models.StandardNavigationBottomItemsData
import com.example.socialmedia.presentation.util.sharedcomposables.StandardNavigationButtonItems


@Composable
fun StandardScaffold(content: @Composable () -> Unit = {} ,
    modifier: Modifier = Modifier,
                      showButtonBar : Boolean = true,
                      navController: NavController,
                     BottomNavigationItem : List<StandardNavigationBottomItemsData>  = listOf(
    StandardNavigationBottomItemsData(
        route = Screens.MainFeedScreen.route,
        icon =  Icons.Outlined.House,
        contentDescription = "Home",
        count = null
    ),
    StandardNavigationBottomItemsData(
        route = Screens.MessagesScreen.route,
        icon =  Icons.Outlined.Message,
        contentDescription = "Message",
        count =  50
    ),
    StandardNavigationBottomItemsData(
        route = Screens.ActivityScreen.route,
        icon =  Icons.Outlined.Notifications,
        contentDescription = "Activity",
        count = null
    ),
    StandardNavigationBottomItemsData(
        route = Screens.ProfileScreen.route,
        icon =  Icons.Outlined.Person,
        contentDescription = "Profile",
        count = null
    ),

)

) { Scaffold(
    bottomBar = {
        if (showButtonBar) {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colors.surface,
            cutoutShape = CircleShape,
            elevation = 5.dp
        ) {
            BottomNavigation {
                    BottomNavigationItem.forEachIndexed { i, bottomNavItem ->
                        StandardNavigationButtonItems(
                            icon = bottomNavItem.icon,
                            contentDescription = bottomNavItem.contentDescription,
                            countNum = bottomNavItem.count,
                            selected = bottomNavItem.route == navController.currentDestination?.route,
                            enabled = bottomNavItem.icon != null,
                            onClick = {
                                bottomNavItem.route?.let {
                                    navController.navigate(it)
                                }

                            }
                        )
                    }
                }
            }
        }
    }
)
{
                  content()
               }
}
