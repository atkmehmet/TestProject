package com.example.a101testunit.utility

import androidx.lifecycle.ViewModel
import com.example.a101testunit.Design.UserViewModel
import com.example.a101testunit.data.Api
import com.example.a101testunit.data.UserRepositoryImpl
import com.example.a101testunit.domain.GetUserNameUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(Api::class.java)
    val repositoryImpl = UserRepositoryImpl(api)
    val useCase = GetUserNameUseCase(repositoryImpl)

    fun providerViewModel():UserViewModel{
        return UserViewModel(useCase)
    }
}