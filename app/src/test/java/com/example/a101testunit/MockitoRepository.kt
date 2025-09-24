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
class MockitoRepository {
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
    fun `repository test for limit` () = runTest {
        val repository = mock<UserRepository>()

        whenever(repository.getUserName()).thenReturn(fakeResponse)
        assertEquals(10,repository.getUserName().limit)
        verify(repository).getUserName()

    }


    @Test
    fun `repository test for user` () = runTest {
        val repository = mock<UserRepository>()

        whenever(repository.getUserName()).thenReturn(fakeResponse)
        assertEquals("Mehmet",repository.getUserName().users[0].firstName)
        verify(repository).getUserName()
        verify(repository).getUserName()

    }
}