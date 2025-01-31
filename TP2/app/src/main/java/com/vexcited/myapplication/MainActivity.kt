package com.vexcited.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import com.vexcited.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            HomeScreen()
          }
        }
      }
    }
  }

  @Composable
  fun HomeScreen() {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }

    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(46.dp, Alignment.CenterVertically),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text("Bienvenue", fontWeight = FontWeight.Bold, fontSize = 36.sp)

      Column (
        modifier = Modifier
          .fillMaxWidth()
          .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = name,
          textAlign = TextAlign.Center
        )

        TextField(
          keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
          ),
          value = name,
          onValueChange = { name = it },
          label = { Text("Saisir votre nom") }
        )

        TextField(
          keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
          ),
          value = year,
          onValueChange = { year = it },
          label = { Text("Saisir votre année de naissance") }
        )

        Button(onClick = {
          if (name.isEmpty() || year.isEmpty()) {
            // show toasts
            Toast.makeText(context, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()

            return@Button
          }

          val intent = Intent(this@MainActivity, MainActivity3::class.java)
          intent.putExtra("USER_NAME", name)
          intent.putExtra("USER_BIRTH_YEAR", year)
          startActivity(intent)

        }) {
          Text("Valider")
        }
      }
    }
  }
}

