package com.example.socialmedia.presentation.util.sharedcomposables

import android.inputmethodservice.Keyboard
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.socialmedia.presentation.ui.theme.HintGray
import com.example.socialmedia.presentation.ui.theme.smallSpace
import kotlin.jvm.Throws

@Composable
@Throws(IllegalArgumentException::class)
fun RowScope.StandardNavigationButtonItems(
    modifier: Modifier = Modifier,
    isSelected : Boolean = false,
    enabled : Boolean = true,
    selectedColor : Color = MaterialTheme.colors.primary,
    unSelectedColor : Color = HintGray,
    onClick : () -> Unit,
    countNum : Int? = null,
    icon: ImageVector? = null,
    contentDescription: String? = null,
    ) {
    if(countNum != null && countNum < 0){
        throw IllegalArgumentException("Couldn't be negative numbers")
    }
    val lineLength = animateFloatAsState(
        targetValue = if(isSelected) 1f else 0f,
        animationSpec = tween(
            durationMillis = 300
        )
    )

    BottomNavigationItem(selected = isSelected ,enabled=enabled, selectedContentColor = selectedColor,
       unselectedContentColor = unSelectedColor, modifier = modifier, icon = { Box(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(smallSpace)
                   .drawBehind {
                       if (lineLength.value > 0f) {
                           drawLine(
                               color = if (isSelected) selectedColor
                               else unSelectedColor,
                               start = Offset(
                                   size.width / 2f - 15.dp.toPx(),
                                   size.height
                               ),
                               end = Offset(
                                   size.width / 2f + 15.dp.toPx(),
                                   size.height
                               ),
                               strokeWidth = 2.dp.toPx(),
                               cap = StrokeCap.Round
                           )
                       }


                   }
       ) {
            if (icon != null) { Icon(imageVector = icon, contentDescription = contentDescription, modifier = Modifier.align(
                Alignment.Center))}
            if (countNum != null){
               val  textCount = if (countNum > 99){
                   "99+"
               }else {
                   countNum.toString()
               }

                Text(
                    text = textCount,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 8.sp,

                    modifier = Modifier.align(Alignment.TopCenter)
                        .align(Alignment.TopCenter)
                        .offset(10.dp)
                        .size(15.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)


                )
            }
           }

           } ,   onClick = onClick)

}
