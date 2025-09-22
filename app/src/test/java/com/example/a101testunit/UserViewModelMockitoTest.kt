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
    fun `repository returns expected response` () = runTest {
        val repo = FakeUserRepository()
        val response = repo.getUserName()
        assertEquals(1,response.users[0].id)
        assertEquals("Mehmet",response.users[0].firstName)
    }


    @Test
    fun `usecase returns expected user` () = runTest {
        val repo = FakeUserRepository()
        val user = GetUserNameUseCase(repo).invoke()
        assertEquals(1,user.size)
        assertEquals("Mehmet",user[0].firstName)
    }



}