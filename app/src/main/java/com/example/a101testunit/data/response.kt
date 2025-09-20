package com.example.a101testunit.data

data class response(
    val users:List<User>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
