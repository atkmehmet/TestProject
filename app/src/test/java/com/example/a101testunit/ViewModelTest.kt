package com.example.a101testunit

import com.example.a101testunit.Design.UserViewModel
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
class ViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var  viewModelTest:UserViewModel

    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
        val repo = FakeUserRepository()
        val useCase = GetUserNameUseCase(repo)
        viewModelTest =  UserViewModel(useCase)
    }

    @Test
    fun `viewModel loads users correctly` () = runTest {
        testDispatcher.scheduler.advanceUntilIdle()
        val user = viewModelTest.users
        assertEquals(1,user.size)
        assertEquals("Mehmet",user[0].firstName)
    }

}