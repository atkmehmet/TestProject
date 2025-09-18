package com.example.a101testunit

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.a101testunit.Design.UserViewModel
import com.example.a101testunit.data.UserRepository
import com.example.a101testunit.domain.GetUserNameUseCase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.a101testunit", appContext.packageName)
    }
}


class FakeUserRepository(): UserRepository {
    override fun getUserName(): String = "Mehmet"

}

class UserViewModelTest{
    private lateinit var viewModel: UserViewModel

    @Before
    fun setUp(){
        val repo = FakeUserRepository()
        val usecase = GetUserNameUseCase(repo)
        viewModel = UserViewModel(usecase)
    }

    @Test
    fun `getName returns Mehmet`() {
        val result = viewModel.getName()
        assertEquals("Mehmet", result)
    }

}