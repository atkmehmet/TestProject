package com.example.a101testunit

import com.example.a101testunit.Design.UserViewModel
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.domain.GetUserNameUseCase
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

class FakeUserRepository: UserRepository {
    override fun getUserName(): String = "Mehmet"
}

class UserViewModelTest {

    private lateinit var viewModel: UserViewModel

    @Before
    fun setUp() {
        val repo = FakeUserRepository()
        val useCase = GetUserNameUseCase(repo)
        viewModel = UserViewModel(useCase)
    }

    @Test
    fun `getName returns Mehmet`() {
        val result = viewModel.getName()
        assertEquals("Mehmet", result)
    }
}