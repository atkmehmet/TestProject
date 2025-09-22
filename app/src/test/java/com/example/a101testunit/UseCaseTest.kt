package com.example.a101testunit

import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.domain.GetUserNameUseCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UseCaseTest {

    private lateinit var  repositoryTest: UserRepository
    private lateinit var useCase: GetUserNameUseCase

    @Before
    fun setUp(){
        repositoryTest = FakeUserRepository()
        useCase = GetUserNameUseCase(repositoryTest)
    }

    @Test
    fun `usecase test` () = runTest {
        val user = useCase.invoke()
        assertEquals("Mehmet",user[0].firstName)
    }
}