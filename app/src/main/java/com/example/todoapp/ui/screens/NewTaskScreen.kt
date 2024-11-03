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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import com.example.todoapp.data.Converters
import com.example.todoapp.data.Priority
import com.example.todoapp.data.Task
import com.example.todoapp.ui.common.ButtonCustom
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar


@Composable
fun  NewTaskScreen(modifier: Modifier, onTaskAdded: (Task) -> Unit) {

    var taskName by remember { mutableStateOf("") }
    var taskDetails by remember { mutableStateOf("") }
    var taskDate by remember { mutableStateOf<LocalDate?>(null) }
    var taskTime by remember { mutableStateOf<LocalTime?>(null) }
    var taskCreation by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        modifier =modifier
            .padding(20.dp, 20.dp)
            .fillMaxSize()
    ) {

        Text("New Tasks",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(0.dp, 5.dp)
        )
        Spacer(Modifier.padding(15.dp))
       FirstPart(taskName , { taskName = it }, taskDetails, {taskDetails = it})

        Spacer(Modifier.padding(15.dp))
        DefineTime(taskDate, {taskDate = it}, taskTime, {taskTime = it} )
        Spacer(Modifier.padding(15.dp))
        TaskCategories()
        //Create Task Button
        Spacer(Modifier.padding(15.dp))
        Button(
            onClick = {

                val creation = LocalDateTime.now()

               val  newTask = Task(
                  title = taskName,
                    description = taskDetails,
                   isCompleted = false,
                  date = taskDate,
                  time = taskTime,
                 creationDate = creation,
               category = "Default",
                priority =  Priority.LOW,


                )
                onTaskAdded(newTask)
                },
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium

        ) {
            Text("Create Task")
        }
    }

}




//Task substask add details
@SuppressLint("InvalidColorHexValue")
@Composable
fun FirstPart(
    taskName: String,
    onTaskNameChange: (String) -> Unit,
    taskDetails: String,
   onTaskDetailChange: (String) -> Unit
) {
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
            value = taskName, //Not Good need To change That
            onValueChange = onTaskNameChange,
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
            value = taskDetails,
            shape = MaterialTheme.shapes.medium,
            onValueChange = onTaskDetailChange,
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
fun DefineTime(selectedDate : LocalDate?, onDateChange: (LocalDate) -> Unit, selectedTime : LocalTime?, onTimeChange : (LocalTime) -> Unit) {

    val calendar = Calendar.getInstance()

    //Date Picker Dialog
     val datePickerDialog = DatePickerDialog(
         LocalContext.current,
         {
             _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
             onDateChange( LocalDate.of(year, month+1, dayOfMonth))
         },
         calendar.get(Calendar.YEAR), calendar.get(Calendar.MONDAY),calendar.get(Calendar.DAY_OF_MONTH)
     )

    //Time Picker
    val timePickerDialog = TimePickerDialog(
        LocalContext.current,
        { _: TimePicker, hourOfDay: Int, minute: Int ->
            onTimeChange(LocalTime.of(hourOfDay, minute))
        },
        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
            Color(0xFFf4f4f4),
            shape = MaterialTheme.shapes.medium),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
            val dateTextValue =  if (selectedDate.toString().isEmpty()) "Pick Date" else "Date Selected"
            val timeTextValue = if (selectedTime.toString().isEmpty()) "Pick Time" else "Time selected"
            ButtonCustom(
                { datePickerDialog.show() },
                dateTextValue
            )
            ButtonCustom(
                { timePickerDialog.show() },
                timeTextValue
            )




        }
        Box{
            if (selectedDate.toString().isNotEmpty()&& selectedTime.toString().isNotEmpty()) {
                Text(text = "Task set for: $selectedDate at $selectedTime")
            }
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
    //NewTaskScreen(modifier = Modifier)



}