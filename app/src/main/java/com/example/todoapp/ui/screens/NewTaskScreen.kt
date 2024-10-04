package com.example.todoapp.ui.screens


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.annotation.SuppressLint
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.common.ButtonCustom
import java.util.Calendar


@Composable
fun  NewTaskScreen(paddingValues: PaddingValues) {

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

@SuppressLint("SuspiciousIndentation")
@Composable
fun DefineTime() {
    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }

    val calendar = Calendar.getInstance()

    //Date Picker Dialog
     val datePickerDialog = DatePickerDialog(
         LocalContext.current,
         {
             _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
             selectedDate = "$dayOfMonth/${month + 1}/$year"
         },
         calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY),calendar.get(Calendar.DAY_OF_MONTH)
     )

    //Time Picker
    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _: TimePicker, hourOfDay: Int, minute: Int ->
            selectedTime = "$hourOfDay:${if (minute < 10) "0$minute" else minute}"
        },
        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                Color(0xFFf4f4f4),
                shape = MaterialTheme.shapes.medium
            ),

        horizontalArrangement = Arrangement.Center,

    ) {
        val dateTextValue =  if (selectedDate.isEmpty()) "Pick Date" else "Date: $selectedDate"
        val timeTextValue = if (selectedTime.isEmpty()) "Pick Time" else "Time: $selectedTime"
            ButtonCustom(
            { datePickerDialog.show() },
            dateTextValue
        )
        ButtonCustom(
            { timePickerDialog.show() },
            timeTextValue
        )


        if (selectedDate.isNotEmpty() && selectedTime.isNotEmpty()) {
            Text(text = "Task set for: $selectedDate at $selectedTime")
        }

    }
}
@Composable
fun TaskCategories() {

    //Need To be a lazyRowComponent
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .background(
                Color(0xFFf4f4f4),
                shape = MaterialTheme.shapes.medium
            )
    )
}


@Preview(showBackground = true)
@Composable
fun NewTaskScreenPreview () {
    //NewTaskScreen(innerPadding)



}