package com.example.a101testunit.domain

import com.example.a101testunit.data.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute ():String = repository.getUserName()
}