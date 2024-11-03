package com.example.todoapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.todoapp.data.Categorie
import com.example.todoapp.ui.common.ItemCard
import com.example.todoapp.ui.common.SimpleCard
import com.example.todoapp.viewmodel.TaskViewModel


@Composable
fun MainScreen(paddingValues: PaddingValues, navController: NavHostController, taskViewModel : TaskViewModel) {
    Column(
        modifier = Modifier.padding(paddingValues),
        verticalArrangement =  Arrangement.spacedBy(12.dp)
    ) {

         FirstComponent(navController)

         SecondComponent(navController, taskViewModel)

         ThirdComponent(navController, taskViewModel)

    }
}



@Composable
fun FirstComponent(navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 22.dp,end=22.dp, top = 30.dp, bottom = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(


        ) {
            Text("Hello Fanny,",
                style = MaterialTheme.typography.titleSmall
            )
            Text("You have work today",
                style = MaterialTheme.typography.labelSmall
            )
        }
        Row {
            Icon(Icons.Default.Notifications, contentDescription = "notif")
            Icon(

                Icons.Default.Face, contentDescription = "face",
                modifier = Modifier
                    .clickable {
                        navController.navigate("thirdPage")
                    }

            )

        }

    }
}

@Composable
fun SecondComponent(navController: NavHostController, taskViewModel: TaskViewModel) {
    val tasks by taskViewModel.taskList.collectAsState(initial = emptyList())
    val taskListSize = tasks.size
    val todaytaskListSize = 0
    val taskOverdueListSize = 0
    val taskScheduledListSize = 0
    val categories = listOf(
        Categorie("Today",icon = Icons.Default.FavoriteBorder, todaytaskListSize,Color(0xFFa9def9 )),
        Categorie("Scheduled",icon = Icons.Default.FavoriteBorder,  taskScheduledListSize , Color(0xFFffe97f)),
        Categorie("All",icon = Icons.Default.FavoriteBorder, taskListSize, Color(0xFFd0f4de)),
        Categorie("Overdue",icon = Icons.Default.FavoriteBorder, taskOverdueListSize, Color(0xFFffc8dd) )

    )
    //val columnCount = if (isTablet) 3 else
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
      .padding(15.dp, 3.dp)

        ) {
        items(categories.size) {index ->

            SimpleCard(
                categories[index].name,
                categories[index].icon,
                categories[index].count,
                categories[index].color

            )

        }
    }
}


@Composable
fun ThirdComponent(navController: NavHostController, taskViewModel: TaskViewModel) {
    val tasks by taskViewModel.taskList.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp)

    ) {
       items(tasks, key = {task -> task.id}) { task ->
           ItemCard(task.title, task.description, task.date, task.time,task.category, task.priority)
       }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Column(
        modifier = Modifier.padding(5.dp),
        verticalArrangement =  Arrangement.spacedBy(12.dp)
    ) {

       // FirstComponent(navController)

 //       SecondComponent(navController)

     //   ThirdComponent(navController)




    }
}