package com.example.a101testunit

import com.example.a101testunit.data.User
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.data.response
import com.example.a101testunit.domain.GetUserNameUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class MockitoUseCase {

val users =  listOf(
    User(
        id = 2,
        firstName = "Mehmet",
        lastName = "Durmaz"
    )
)
    val fakeResponse = response(
        limit = 10,
        total = 2,
        skip = 3,
        users = listOf(
            User(
                id = 2,
                firstName = "Mehmet",
                lastName = "Durmaz"
            )
        )
    )


    @Test
    fun `test for Usecase` () = runTest {
        val repository = mock<UserRepository>()


        whenever(repository.getUserName()).thenAnswer { fakeResponse }
        val users = GetUserNameUseCase(repository).invoke()

        assertEquals("Mehmet",users.forEach { it.firstName })
        verify(repository).getUserName()
    }
}