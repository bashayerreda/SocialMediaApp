package com.example.socialmedia.presentation.ui.loginscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel(){
    private val _userNameText = mutableStateOf("")
    val usernameText: State<String> = _userNameText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun takeUsernameFromView(username : String){
        viewModelScope.launch {
            _userNameText.value = username
        }
    }
    fun takePasswordFromView(password: String){
        viewModelScope.launch {
            _passwordText.value = password
        }
    }
    fun setIsUsernameError(error: String) {
        _usernameError.value = error
    }

    fun setIsPasswordError(error: String) {
        _passwordError.value = error
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

}