package com.vexcited.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.vexcited.myapplication.core.AgeCalculator
import com.vexcited.myapplication.ui.theme.MyApplicationTheme

class MainActivity3 : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Box(modifier = Modifier.fillMaxSize().padding(innerPadding), contentAlignment = Alignment.Center) {
            PresentationScreen()
          }
        }
      }
    }
  }

  @Composable
  fun PresentationScreen() {
    val userName = intent.getStringExtra("USER_NAME") ?: ""
    val userBirthYear = intent.getStringExtra("USER_BIRTH_YEAR") ?: ""
    val userAge = AgeCalculator.calculateAge(userBirthYear.toInt())

    Text("Hello $userName vous avez $userAge ans !", textAlign = TextAlign.Center)
  }
}


