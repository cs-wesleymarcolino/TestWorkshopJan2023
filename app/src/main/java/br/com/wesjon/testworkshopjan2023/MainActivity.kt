package br.com.wesjon.testworkshopjan2023

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import br.com.wesjon.testworkshopjan2023.ui.theme.TestWorkshopJan2023Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestWorkshopJan2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen { email, password ->
                        validateFields(email, password)
                    }
                }
            }
        }
    }

    private fun validateFields(email: String, password: String) {
        when {
            email.isBlank() -> {
                showError(getString(R.string.error_empty_email))
            }
            password.isBlank() -> {
                showError(getString(R.string.error_empty_password))
            }
        }
    }

    private fun showError(message: String) {
        AlertDialog.Builder(this@MainActivity)
            .setMessage(message)
            .show()
    }
}