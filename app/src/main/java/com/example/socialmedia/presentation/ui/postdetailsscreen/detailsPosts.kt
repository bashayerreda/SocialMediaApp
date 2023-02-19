package com.example.socialmedia.presentation.ui.postdetailsscreen

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmedia.R
import com.example.socialmedia.domain.models.Comments
import com.example.socialmedia.domain.models.Post
import com.example.socialmedia.presentation.ui.theme.*
import com.example.socialmedia.presentation.util.Constants
import com.example.socialmedia.presentation.util.sharedcomposables.ActionRow

@Composable
fun detailsPosts(
    post: Post,
    modifier: Modifier = Modifier,
    showProfileImage: Boolean = true,
    onPostsClicked :() -> Unit = {}
) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.surface)) {
        item {
            //first column only for change background color because of its similar as toolbar color
             Column(modifier = Modifier
                 .fillMaxWidth()
                 .background(MaterialTheme.colors.background)) {

                 Box(
                     modifier = modifier
                         .fillMaxSize()


                 ) {
                     Column(
                         modifier = Modifier
                             .fillMaxSize()
                             .offset(
                                 y = if (showProfileImage) {
                                     ProfilePictureSizeMedium / 2f
                                 } else 0.dp
                             )
                             .clip(MaterialTheme.shapes.medium)
                             .shadow(5.dp)
                             .background(MediumGray)
                             .clickable {
                                 onPostsClicked()
                             }

                     ) {
                         Image(
                             painterResource(id = R.drawable.kermit),
                             contentDescription = Constants.POSTS_COVER_PHOTO,

                             )
                         Column(
                             modifier = Modifier
                                 .fillMaxWidth()
                                 .padding(mediumSpace)
                         ) {
                             if (post.userName != null) {
                                 ActionRow(username = post.userName,
                                     modifier = Modifier.fillMaxWidth(),
                                     likeButtonClicked = {

                                     },
                                     commentClicked = {

                                     },
                                     shareClicked = {

                                     },
                                     onUsernameClick = { userName ->

                                     })
                             }
                             Spacer(modifier = Modifier.height(smallSpace))
                             post.description?.let {
                                 Text(
                                     text = it
                                 )
                             }
                             Spacer(modifier = Modifier.height(smallSpace))
                             Row(
                                 modifier = Modifier.fillMaxWidth(),
                                 horizontalArrangement = Arrangement.SpaceBetween
                             ) {
                                 Text(
                                     text = stringResource(
                                         id = R.string.likedbyxpeople,
                                         post.likesCount!!
                                     ),
                                     fontWeight = FontWeight.Bold,
                                     fontSize = 16.sp,
                                     style = MaterialTheme.typography.h2
                                 )


                             }
                         }
                     }


                     Image(
                         painterResource(id = R.drawable.bashayer),
                         contentDescription = Constants.PROFILE_PIC_FOR_POSTS,
                         modifier = Modifier
                             .size(ProfilePictureSizeMedium)
                             .clip(CircleShape)
                             .align(alignment = Alignment.TopCenter)

                     )
                 }
             }
            Spacer(modifier = Modifier.height(mediumSpace))
        }
       
        items(20) {
            CommentsCard(
                comments = Comments(

                    userName = "Bashayer$it",
                    comment = "Lorem ipsum dolor sit amet, consetetur, asdfadsf\n" +
                            "diam nonumy eirmod tempor invidunt ut fda fdsa\n" +
                            "magna aliquyam erat, sed diam voluptua" +
                            "Lorem ipsum dolor sit amet, consetetur, asdfadsf\\n\"",
                ), modifier = modifier.padding(mediumSpace)
            )
        }

    }
 }




@Composable
fun CommentsCard(modifier: Modifier = Modifier ,comments: Comments, onLikeClicked :(Boolean) -> Unit = {}){
    Card(  modifier = modifier.fillMaxWidth(),
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
        backgroundColor = MaterialTheme.colors.onSurface,) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(mediumSpace)
         ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) { Row()
            {
                Image(
                    painter = painterResource(id = R.drawable.bashayer),
                     //comments.imageurl
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(ProfilePictureSizeExtraSmall)
                )
                Spacer(modifier = Modifier.width(smallSpace))
                Text(
                    text = comments.userName!!,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.onBackground
                )
            }
            Text(
                text = //comments.timestamp.toString(),
                       "2 days ago",
                style = MaterialTheme.typography.body2
            )
        }
            Spacer(modifier = Modifier.height(mediumSpace))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
         Text(text = comments.comment!! , style = MaterialTheme.typography.body2,  modifier = Modifier.weight(9f))
                Spacer(modifier = modifier.width(mediumSpace))
               IconButton(onClick = { onLikeClicked(comments.isLiked)}) {
                   Icon(imageVector = Icons.Default.Favorite,
                       contentDescription = if (comments.isLiked) {
                           stringResource(id = R.string.unlike)
                       } else stringResource(id = R.string.liked))
               }

            }
            Spacer(modifier = Modifier.height(mediumSpace))
            Text(
                text = stringResource(id = R.string.likedbyxpeople, comments.likesCount),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onBackground
            )

        }
    }

}