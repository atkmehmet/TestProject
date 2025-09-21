package com.example.a101testunit.Design

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a101testunit.data.User

import com.example.a101testunit.domain.GetUserNameUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val userNameUseCase: GetUserNameUseCase
):ViewModel() {

    var users by mutableStateOf<List<User>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            users = userNameUseCase()

           // Log.d("API", response.users.toString())
        }
    }

}
