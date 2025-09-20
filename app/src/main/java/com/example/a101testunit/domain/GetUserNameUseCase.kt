package com.example.a101testunit.domain

import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response

class GetUserNameUseCase(private val repository: UserRepository) {

    suspend fun execute ():response = repository.getUserName()
}