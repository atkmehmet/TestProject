package com.example.a101testunit

import com.example.a101testunit.Design.UserViewModel
import com.example.a101testunit.data.User
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response
import com.example.a101testunit.domain.GetUserNameUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test


class FakeUserRepository: UserRepository {
    override suspend fun getUserName(): response{
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

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: UserViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        val repo = FakeUserRepository()
        val useCase = GetUserNameUseCase(repo)
        viewModel = UserViewModel(useCase)
    }

    @Test
    fun `getName returns Mehmet`() = runTest  {
        val result = viewModel.users
        var firstName = ""
         result.forEach {
             firstName = it.firstName
         }
        assertEquals("Mehmet", firstName)
    }
}