package br.com.wesjon.testworkshopjan2023.presenter

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import br.com.wesjon.testworkshopjan2023.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val context = LocalContext.current as? Activity

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(text = "Home Page")
        Button(
            onClick = {
                val main = Intent(context, MainActivity::class.java)

                context?.startActivity(main)
                context?.finish()
            }) {
            Text(text = "Sair")
        }
    }

}