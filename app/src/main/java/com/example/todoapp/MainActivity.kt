package com.example.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

import androidx.navigation.compose.*
import com.example.todoapp.data.DatabaseProvider
import com.example.todoapp.data.TaskRepository
import com.example.todoapp.data.TaskViewModelFactory
import com.example.todoapp.ui.screens.MainScreen
import com.example.todoapp.ui.screens.NewTaskScreen
import com.example.todoapp.ui.screens.UserAccountScreen
import com.example.todoapp.ui.theme.TodoAppTheme
import com.example.todoapp.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Initialiser la base de données et le repository

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
    val database = DatabaseProvider.getDatabase(LocalContext.current)
    val  taskRepository = TaskRepository(database.taskDao())

    // Navigation avec le NavHost
    NavHost(navController = navController, startDestination = "mainPage") {
        // Composable pour la page principale
        composable("mainPage") { MainPage(navController, taskRepository) }
        // Composable pour la deuxième page
        composable("secondPage") { SecondPage(navController, taskRepository) }

        //Composable pour la troisième page
        composable("thirdPage") { ThirdPage() }
    }
}
@Composable
fun MainPage(navController: NavHostController, taskRepository: TaskRepository) {
    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(taskRepository)
    )

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
        MainScreen(paddingValues = innerPadding, navController, taskViewModel)

    }
}
@Composable
fun SecondPage(navController: NavHostController, taskRepository: TaskRepository) {
    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(taskRepository)
    )
    Scaffold(modifier = Modifier.fillMaxSize(),
    ) { innerPadding  ->
        NewTaskScreen(
            modifier = Modifier.padding(innerPadding),
            onTaskAdded = {
                task -> taskViewModel.addTask(task);
                navController.navigate("mainPage")

            }
            )
    }
}


@Composable
fun ThirdPage() {
    Scaffold {
        innerPadding -> UserAccountScreen(modifier = Modifier.padding(innerPadding))
    }
}
/**
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

            MainScreen(paddingValues = innerPadding, navController = navController)


        }
    }
}*/