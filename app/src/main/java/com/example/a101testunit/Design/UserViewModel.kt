package com.example.a101testunit.Design

import androidx.lifecycle.ViewModel
import com.example.a101testunit.domain.GetUserNameUseCase

class UserViewModel(
    private val userNameUseCase: GetUserNameUseCase
):ViewModel() {

    fun getName () :String = userNameUseCase.execute()
}