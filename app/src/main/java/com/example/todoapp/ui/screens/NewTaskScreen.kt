package com.example.todoapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun  NewTaskScreen() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        modifier = Modifier
            .padding(20.dp, 20.dp)
            .fillMaxSize()
    ) {

        Text("New Tasks",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(0.dp, 5.dp)
        )
        Spacer(Modifier.padding(15.dp))
       FirstPart()
        Spacer(Modifier.padding(15.dp))
        DefineTime()
        Spacer(Modifier.padding(15.dp))
        TaskCategories()
        //Create Task Button
    }

}




//Task substask add details
@SuppressLint("InvalidColorHexValue")
@Composable
fun FirstPart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFf4f4f4),
                shape = MaterialTheme.shapes.medium
            )
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .height(50.dp)
                .fillMaxSize()
                .shadow( 0.dp, shape = MaterialTheme.shapes.medium),
            value = "", //Not Good need To change That
            onValueChange = {},
            shape = MaterialTheme.shapes.medium,
            textStyle = MaterialTheme.typography.bodySmall,
            placeholder = {
                Text( text ="Task name",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF9999a1)
                )

            }
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .height(120.dp)
                .fillMaxSize()
            ,
            singleLine = false,
            value = "",
            shape = MaterialTheme.shapes.medium,
            onValueChange = {},
            placeholder = {
                Text( text ="Add your task details",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF9999a1)
                )

            }
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