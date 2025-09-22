package com.example.a101testunit

import com.example.a101testunit.data.UserRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryTest {
    private lateinit var  repositoryTest:UserRepository

    @Before
    fun setup(){
        repositoryTest = FakeUserRepository()
    }

    @Test
    fun  `repository test` () = runTest {

        val response = repositoryTest.getUserName()
        assertEquals(10,response.limit)
        assertEquals("Mehmet",response.users[0].firstName)
    }
}