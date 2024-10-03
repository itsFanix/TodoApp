package com.example.todoapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun  NewTaskScreen() {



    Column(
        verticalArrangement = Arrangement.SpaceBetween,


        modifier = Modifier
            .padding(20.dp, 150.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text("New Tasks",
            style = MaterialTheme.typography.headlineMedium
        )
       FirstPart()
        DefineTime()
        TaskCategories()


        //Create Task Button
    }

}




//Task substask add details
@Composable
fun FirstPart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.padding(10.dp),
            value = "Todo name",
            onValueChange = {}
        )

        TextField(
            modifier = Modifier.padding(10.dp),
            value = "Add your task details",
            onValueChange = {}
        )

    }


}

//Time to accompish the task hour minut second
@Composable
fun DefineTime() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .background(Color.Red)
    )
}

@Composable
fun TaskCategories() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .background(Color.Blue)
    )
}


@Preview(showBackground = true)
@Composable
fun NewTaskScreenPreview () {
    NewTaskScreen()



}