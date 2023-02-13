package com.example.socialmedia.presentation.ui.postsfeeds

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.example.socialmedia.domain.models.Post
import com.example.socialmedia.presentation.ui.theme.*
import com.example.socialmedia.presentation.util.Constants
import com.example.socialmedia.presentation.util.sharedcomposables.ActionRow


@Composable
fun Posts(
    post: Post,
    modifier: Modifier = Modifier,
    showProfileImage: Boolean = true,
    onPostsClicked :() -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(mediumSpace)

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = if (showProfileImage) {
                    ProfilePictureSizeMedium / 2f
                } else 0.dp)
                .clip(MaterialTheme.shapes.medium)
                .shadow(5.dp)
                .background(MediumGray)

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
                    ActionRow(username = post.userName, modifier = Modifier.fillMaxWidth(),
                        likeButtonClicked = {

                    }, commentClicked = {

                    }, shareClicked = {

                    }, onUsernameClick = { userName ->

                        })
                }
                Spacer(modifier = Modifier.height(smallSpace))
                Text(
                    text = buildAnnotatedString {
                        append(let { post.description.toString() })
                        withStyle(
                            SpanStyle(
                                color = HintGray,
                            )
                        ) {
                            append(
                                LocalContext.current.getString(
                                    R.string.read_more
                                )
                            )
                        }
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.MAX_LINES
                )
                Spacer(modifier = Modifier.height(smallSpace))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.likedbyxpeople, post.likesCount!!),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.h2
                    )
                    Text(
                        text = stringResource(
                            id = R.string.commentsbyxpeople,
                            post.commentsCount!!
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


