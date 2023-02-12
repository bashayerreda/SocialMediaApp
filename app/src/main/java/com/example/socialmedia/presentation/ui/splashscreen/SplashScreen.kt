package com.example.socialmedia.presentation.ui.splashscreen

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.socialmedia.R
import com.example.socialmedia.presentation.ui.theme.DarkGray
import com.example.socialmedia.presentation.util.Constants
import com.example.socialmedia.presentation.util.Screens
import com.example.socialmedia.presentation.util.navigation
import kotlinx.coroutines.*


@Composable
fun splashScreen(navController: NavController, dispatcher: CoroutineDispatcher = Dispatchers.Main){
   val scale = remember {
      androidx.compose.animation.core.Animatable(0f)
   }
    val overshootInterpolator =  remember {
             OvershootInterpolator(2f)
    }
   LaunchedEffect(key1 = true){
       withContext(dispatcher){
           scale.animateTo(
               targetValue = 0.9f,
               animationSpec = tween(
                   durationMillis = 1000,
                   easing = {
                       overshootInterpolator.getInterpolation(it)
                   }
               )
           )
           delay(Constants.DELAY_FOR_SPLASH_SCREEN)
           navController.popBackStack()
           navController.navigate(Screens.LoginScreen.route)
       }
       }

   Box(
      modifier = Modifier.fillMaxSize(),
      contentAlignment = Alignment.Center
   )
   {

      Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo", modifier = Modifier.scale(scale.value))


   }
}