package com.example.socialmedia.presentation.ui.loginscreen
import androidx.compose.foundation.clickable
import com.example.socialmedia.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialmedia.presentation.ui.theme.largeSpace
import com.example.socialmedia.presentation.ui.theme.mediumSpace
import com.example.socialmedia.presentation.ui.theme.smallSpace
import com.example.socialmedia.presentation.util.InputText
import com.example.socialmedia.presentation.util.Screens
import com.google.accompanist.flowlayout.FlowCrossAxisAlignment

@Composable
fun logInScreen(navController: NavController,viewModel: LoginViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = smallSpace,
                end = smallSpace,
                top = smallSpace,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = mediumSpace)

        )
        {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(mediumSpace))

            InputText(text = viewModel.usernameText.value,
                hint = stringResource(id = R.string.EnterusernameorEmail),
                keyBoardType = KeyboardType.Email,
                onValueChanged = {
                    viewModel.takeUsernameFromView(it)
                })
            Spacer(modifier = Modifier.height(smallSpace))
            InputText(text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.Enterpassword),
                error = viewModel.passwordError.value,
                onValueChanged = {
                    viewModel.takePasswordFromView(it)
                },

                keyBoardType = KeyboardType.Password,
                isPasswordVisible = viewModel.showPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowPassword(it)
                }

            )

            Spacer(modifier = Modifier.height(smallSpace))
            Button(
                onClick = {
                    navController.navigate(
                        Screens.MainFeedScreen.route
                    )
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colors.onPrimary
                )
            }

            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = R.string.dont_have_an_account_yet))
                    append(" ")
                    val signUpText =
                        stringResource(id = R.string.sign_up)
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.primary
                        ),
                    ) {
                        append(signUpText)
                    }
                },
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                   .align(Alignment.CenterHorizontally)
                    .clickable {
                        navController.navigate(
                            Screens.RegisterScreen.route
                        )
                    }

            )

        }

    }
}

