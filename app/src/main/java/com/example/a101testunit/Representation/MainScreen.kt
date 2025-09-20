package com.example.a101testunit.Representation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.a101testunit.utility.ServiceLocator
@Composable
fun MainScreen() {
    val viewModel = remember { ServiceLocator.providerViewModel() }

    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        if (viewModel.users.isEmpty()) {
            Text("Loading...")
        } else {
            viewModel.users.forEach { user ->
                Row {
                    Text(text = user.firstName)
                }
            }
        }
    }
}
