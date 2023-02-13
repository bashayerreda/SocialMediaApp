package com.example.socialmedia.presentation.registerscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor() : ViewModel() {
    private val _userNameText = mutableStateOf("")
    val usernameText: State<String> = _userNameText

    private val _email = mutableStateOf("")
    val email : State<String> = _email

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    private val _mailError = mutableStateOf("")
    val mailError: State<String> = _mailError

    fun takeUsernameFromView(username : String){
        viewModelScope.launch {
            _userNameText.value = username
        }
    }
    fun takeMailFromView(email : String){
        viewModelScope.launch {
            _email.value = email
        }
    }

    fun setIsEmailError(error: String) {
        viewModelScope.launch {
            _mailError.value = error
        }
    }
    fun takePasswordFromView(password: String){
        viewModelScope.launch {
            _passwordText.value = password
        }
    }
    fun setIsUsernameError(error: String) {
        viewModelScope.launch {
            _usernameError.value = error
        }
    }

    fun setIsPasswordError(error: String) {
        viewModelScope.launch {
            _passwordError.value = error
        }
    }

    fun setShowPassword(showPassword: Boolean) {
        viewModelScope.launch {
        _showPassword.value = showPassword
    }

}
}