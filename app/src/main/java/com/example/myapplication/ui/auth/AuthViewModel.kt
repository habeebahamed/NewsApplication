package com.example.myapplication.ui.auth

import android.media.session.MediaSession.Token
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.network.AuthApi
import com.example.myapplication.data.network.Resources
import com.example.myapplication.data.repository.AuthRepository
import com.example.myapplication.data.responses.LoginResponse
import kotlinx.coroutines.launch
import java.net.PasswordAuthentication

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel(){

    private val _loginResponse : MutableLiveData<Resources<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resources<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }

    fun saveAuthToken(token: String) = viewModelScope.launch {
        repository.saveAuthToken(token)
    }

}