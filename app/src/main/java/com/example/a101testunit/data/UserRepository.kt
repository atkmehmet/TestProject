package com.example.a101testunit.data

interface UserRepository {
  suspend  fun getUserName(): response
}