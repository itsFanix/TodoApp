package com.example.todoapp.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable

fun CheckBoxCustom(checked: Boolean, taskIsDone: (Boolean) -> Unit) {

    //var isChecked by remember { mutableStateOf(false) }

    Checkbox(
        checked = checked,
        onCheckedChange = {isChecked -> taskIsDone(isChecked)}
    )
  /*  Box(
        modifier = Modifier
            .size(20.dp)
            .clip(CircleShape)
            .background(
                color =  Color.White
            )
            .border(
                BorderStroke(2.dp, if(isChecked) Color.Green else Color(0xFFa9def9 )),
                shape = CircleShape
            )
            .clickable { isChecked = !isChecked },
        contentAlignment = Alignment.Center
    )

    {
        if (isChecked) {

            Icon(
                imageVector = Icons.Default.Check,
                "Checked",
                tint = Color.Blue
            )
        }


    }*/
}
