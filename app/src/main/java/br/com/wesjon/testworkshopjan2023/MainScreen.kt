package br.com.wesjon.testworkshopjan2023

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(onClick: (email: String, password: String) -> Unit) {
    MainScreenContent(onClick)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun MainScreenContent(onClick: (email: String, password: String) -> Unit) {
    var emailField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.LoginScreen.EMAIL),
            value = emailField,
            onValueChange = { emailField = it },
            label = { Text(text = "Email") },
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.LoginScreen.PASSWORD),
            value = passwordField,
            onValueChange = { passwordField = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .testTag(TestTags.LoginScreen.LOGIN_BUTTON),
            onClick = {
                onClick(emailField, passwordField)
            }) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun PreviewMainScreenContent() {
    MainScreen(onClick = { _, _ -> })
}