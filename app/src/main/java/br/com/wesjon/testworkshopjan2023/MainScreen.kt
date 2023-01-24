package br.com.wesjon.testworkshopjan2023

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import br.com.wesjon.testworkshopjan2023.presenter.HomeActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var emailField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }
    val validator = PasswordValidator()
    val context = LocalContext.current as? Activity

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = emailField,
            onValueChange = { emailField = it },
            label = { Text(text = "Email") },
        )
        TextField(
            value = passwordField,
            onValueChange = { passwordField = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
            if (validator.login(emailField, passwordField)) {
                val home = Intent(context, HomeActivity::class.java)

                context?.startActivity(home)
                context?.finish()
            }
            else
                Toast.makeText(context, "Erro: tem algo errado...", Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Login")
        }
    }
}