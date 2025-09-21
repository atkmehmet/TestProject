package com.example.a101testunit

import com.example.a101testunit.data.User
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response


class FakeRepository : UserRepository {
    override suspend fun getUserName(): response {
        return response(
            limit = 10,
            users = listOf(User(1, "Mehmet", "Durmaz")),
            total = 2,
            skip = 5
        )
    }
}

class UsecaseTest {

    private val fakeRepository = FakeRepository()

}