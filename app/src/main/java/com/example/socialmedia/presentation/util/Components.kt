package com.example.socialmedia.presentation.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.socialmedia.R


//Change State based on send data to viewModel viewmodel will manage state
@Composable
fun InputText(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    isError : Boolean = false,
    maxSize : Int = 40,
    keyBoardType : KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit,
    isPasswordToggleDisplayed: Boolean = keyBoardType == KeyboardType.Password,
    isPasswordVisible: Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
) {

   TextField(
       value =text
       , onValueChange = {
           if (it.length <= maxSize){
               onValueChanged(it)
           }
       },

       placeholder = {
           Text(
           text = hint,
               style = MaterialTheme.typography.body1
           )

       }, isError = isError,
       keyboardOptions = KeyboardOptions(
           keyboardType = keyBoardType
       ),
       visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
           PasswordVisualTransformation()
       } else {
           VisualTransformation.None
       },

       trailingIcon = if(isPasswordToggleDisplayed) {
           val icon: @Composable () -> Unit = {
               IconButton(
                   onClick = {
                       onPasswordToggleClick(!isPasswordVisible)
                   },

               ) {
                   Icon(
                       imageVector = if (isPasswordVisible) {
                           Icons.Filled.VisibilityOff
                       } else {
                           Icons.Filled.Visibility
                       },
                       tint = Color.White,
                       contentDescription = if (isPasswordVisible) {

                           stringResource(id = R.string.password_visible_content_description)
                       } else {
                           stringResource(id = R.string.password_hidden_content_description)
                       }
                   )
               }
           }
           icon
       } else null,





       modifier = modifier.fillMaxWidth()



   )

}


//change password state based on remember
/*@Composable
fun InputText(
    Text: String = "",
    hint: String = "",
    isError : Boolean = false,
    keyBoardType : KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit,

) {
    val passwordDisplayed by remember {
        mutableStateOf(keyBoardType == KeyboardType.Password)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value =Text
        , onValueChange =  onValueChanged,
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.body1
            )

        }, isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType
        ),
        visualTransformation = if (!isPasswordVisible && passwordDisplayed) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },

       trailingIcon = {
           if (passwordDisplayed) {
               IconButton(
                   onClick = {
                       isPasswordVisible = !isPasswordVisible
                   }) {


                   Icon(
                       imageVector = if (isPasswordVisible) {
                           Icons.Filled.VisibilityOff
                       } else {
                           Icons.Filled.Visibility
                       },
                       tint = Color.White,
                       contentDescription = if (isPasswordVisible) {

                           stringResource(id = R.string.password_visible_content_description)
                       } else {
                           stringResource(id = R.string.password_hidden_content_description)
                       }
                   )
               }
           }
       },

           modifier = Modifier.fillMaxWidth()

           )
       }*/

