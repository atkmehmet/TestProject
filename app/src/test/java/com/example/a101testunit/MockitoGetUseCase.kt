package com.example.a101testunit

import com.example.a101testunit.Design.UserViewModel
import com.example.a101testunit.data.User
import com.example.a101testunit.domain.GetUserNameUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class MockitoGetUseCase {


    private lateinit var getUserNameUseCase: GetUserNameUseCase
    private lateinit var viewModel: UserViewModel
    val usersTest = listOf(
        User(
            id = 1,
            firstName = "Mehmet",
            lastName = "Durmaz"
        )
    )
    @Before
    fun setUp(){
        Dispatchers.setMain(StandardTestDispatcher())

        getUserNameUseCase = mock()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun `GetUseCase test` () = runTest {



        whenever(getUserNameUseCase.invoke()).thenReturn(usersTest)

        viewModel = UserViewModel(getUserNameUseCase)
        advanceUntilIdle()

        assertEquals("Mehmet",viewModel.users[0].firstName)
        verify(getUserNameUseCase).invoke()


    }
}