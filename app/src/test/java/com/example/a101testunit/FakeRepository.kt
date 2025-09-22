package com.example.a101testunit

import com.example.a101testunit.data.User
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response

class FakeUserRepository: UserRepository {
    override suspend fun getUserName(): response {
        return response(
            limit = 10,
            users = listOf(
                User(
                    id = 1,
                    firstName = "Mehmet",
                    lastName = "Durmaz"
                )
            ),
            total =2,
            skip = 5
        )
    }
}
