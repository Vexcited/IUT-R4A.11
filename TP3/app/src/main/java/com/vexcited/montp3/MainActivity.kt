package com.vexcited.montp3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vexcited.montp3.ui.theme.MonTP3Theme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MonTP3Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Box(
            modifier = Modifier.padding(innerPadding)
          ) {
            AppNavigation()
          }
        }
      }
    }
  }
}

@Composable
fun AppNavigation () {
  val navController = rememberNavController();

  NavHost(
    navController,
    startDestination = "home"
  ) {
    composable("home") {
      HomeScreen(navController)
    }
    composable("form") {
      FormScreen(navController)
    }
    composable(
      route = "display/{name}/{age}",
      arguments = listOf(
        navArgument("name") { defaultValue = "" },
        navArgument("age") { defaultValue = "" },
      )
    ) { backStackEntry ->
      val name = backStackEntry.arguments?.getString("name") ?: ""
      val age = backStackEntry.arguments?.getString("age") ?: ""
      DisplayScreen(navController, name, age)
    }
  }
}

@Composable
fun HomeScreen (navController: NavController) {
  Column (
    modifier = Modifier.fillMaxSize().padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      "Bienvenue dans ma première application compose navigation",
      style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(24.dp))
    Button(onClick = {
      navController.navigate("form")
    }) {
      Text("Accéder au formulaire")
    }
  }
}

@Composable
fun FormScreen(navController: NavController) {
  var name by remember { mutableStateOf("") }
  var age by remember { mutableStateOf("") }

  Column (
    modifier = Modifier.fillMaxSize().padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      "Page du formulaire",
      style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(24.dp))

    TextField(
      value = name,
      onValueChange = { name = it },
      label = { Text("Entrez votre nom") },
      modifier = Modifier.fillMaxWidth().padding(16.dp)
    )

    TextField(
      value = age,
      onValueChange = { age = it },
      label = { Text("Entrez votre âge") },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      modifier = Modifier.fillMaxWidth().padding(16.dp)
    )

    Button(onClick = {
      if (!name.trim().isEmpty() and !age.trim().isEmpty()) {
        navController.navigate("display/$name/$age")
      }
    }) {
      Text("Valider")
    }

    Button(onClick = {
      navController.popBackStack()
    }) {
      Text("Retour")
    }
  }
}

@Composable
fun DisplayScreen(navController: NavController, name: String, age: String) {
  Column (
    modifier = Modifier.fillMaxSize().padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      "Affichage du formulaire",
      style = MaterialTheme.typography.titleMedium
    )

    Text(
      text = name,
      style = MaterialTheme.typography.titleMedium
    )
    Text(
      text = age,
      style = MaterialTheme.typography.titleMedium
    )

    Button(onClick = {
      navController.popBackStack()
    }) {
      Text("Retour")
    }
  }
}