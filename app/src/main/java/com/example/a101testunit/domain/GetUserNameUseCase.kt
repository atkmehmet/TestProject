package com.example.a101testunit.domain

import com.example.a101testunit.data.User
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response

class GetUserNameUseCase(private val repository: UserRepository) {

    suspend operator fun invoke ():List<User>{
        return repository.getUserName().users
    }
}