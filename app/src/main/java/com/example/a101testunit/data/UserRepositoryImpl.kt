package com.example.a101testunit.data

class UserRepositoryImpl(
    private val api: Api
):UserRepository {
    override suspend fun getUserName() = api.getUsers()
}