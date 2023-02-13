package com.example.socialmedia.presentation.util.sharedcomposables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.socialmedia.R
import com.example.socialmedia.presentation.ui.theme.TextWhite
import com.example.socialmedia.presentation.ui.theme.mediumSpace
import com.example.socialmedia.presentation.ui.theme.smallSpace
import com.example.socialmedia.presentation.util.Constants
import com.example.socialmedia.presentation.util.Constants.Companion.iconSize

@Composable
fun engagementButtons(
    modifier: Modifier = Modifier,
    isLiked : Boolean = false,
    likeButtonClicked : (Boolean) -> Unit = {},
    commentClicked : () -> Unit = {},
    shareClicked : () -> Unit = {}

    
){
    Row(horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
       IconButton(onClick = { likeButtonClicked(!isLiked) }) {
           Icon(imageVector = Icons.Filled.Favorite,  tint = if (isLiked) {
               Color.Red
           } else {
               TextWhite
           }, contentDescription = if (isLiked){
               stringResource(id = R.string.unlike)

           }else {
               stringResource(id = R.string.liked)
           })
           
       }
        Spacer(modifier = modifier.width(smallSpace))
        IconButton(onClick = { commentClicked() },modifier = Modifier.size(iconSize)) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(id = R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(smallSpace))
        IconButton(
            onClick = {
                shareClicked()
            },
            modifier = Modifier.size(iconSize)
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(id = R.string.share)
            )
        }
    }
}
@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
   // isLiked: Boolean = false,
   // onLikeClick: (Boolean) -> Unit = {},
  //  onCommentClick: () -> Unit = {},
  //  onShareClick: () -> Unit = {},
    username: String,
    onUsernameClick: (String) -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Text(
            text = username,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            ),
            modifier = Modifier
                .clickable {
                    onUsernameClick(username)
                }
        )
       engagementButtons()
    }
}
