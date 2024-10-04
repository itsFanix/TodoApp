package com.example.todoapp.ui.common

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ButtonCustom(
    onClickAction: () -> Unit,
    textValue: String,
) {

    Button(
        onClick = onClickAction,
        Modifier.padding(9.dp),
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            Color(0xFFd0f4de)
        )

    ) {
        Text(
            textValue,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }

}