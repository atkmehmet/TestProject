package com.example.a101testunit.data

import retrofit2.http.GET

interface Api {


    @GET("users")
    suspend fun getUsers():response
}