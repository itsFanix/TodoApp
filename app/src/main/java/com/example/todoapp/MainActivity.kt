package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

import androidx.navigation.compose.*
import com.example.todoapp.ui.screens.MainScreen
import com.example.todoapp.ui.screens.NewTaskScreen
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
              MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // Contrôleur de navigation
    val navController = rememberNavController()

    // Navigation avec le NavHost
    NavHost(navController = navController, startDestination = "mainPage") {
        // Composable pour la page principale
        composable("mainPage") { MainPage(navController) }
        // Composable pour la deuxième page
        composable("secondPage") { SecondPage() }
    }
}
@Composable
fun MainPage(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("secondPage")
            },
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { innerPadding ->

        MainScreen(paddingValues = innerPadding)



    }
}




@Composable
fun SecondPage() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {

            },
                shape = MaterialTheme.shapes.extraLarge
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { innerPadding  ->

        NewTaskScreen(paddingValues = innerPadding)



    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(onClick = {},
                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }

        ) { innerPadding ->

            MainScreen(paddingValues = innerPadding)



        }
    }
}