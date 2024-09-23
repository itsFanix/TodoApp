package com.example.todoapp.ui.common


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun SimpleCard(name: String, icon: ImageVector, numberOfTask: Int, backgroundColor: Color){
   Card(
      modifier = Modifier
         .size(100.dp)
         .padding(6.dp, 4.dp)
      ,
      colors = CardDefaults.cardColors(
         containerColor = backgroundColor
      )

   ) {
      Column(
         modifier = Modifier
            .fillMaxSize()
            .padding(14.dp, 7.dp)
         ,
         verticalArrangement = Arrangement.SpaceBetween
      ) {
         //Icon
         Box(
            modifier = Modifier
               .size(40.dp)
               .clip(CircleShape)
               .background(MaterialTheme.colorScheme.onSecondary)

         ){
            Icon(
               imageVector = icon,
               contentDescription = null,
               modifier = Modifier
                  .size(30.dp)
                  .align(Alignment.Center)
            )

         }

         //Information
         Row(
            modifier = Modifier
               .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

         ) {
            Text(
               text = name,
               style = MaterialTheme.typography.titleMedium
            )

            Text(
               text = "$numberOfTask"
            )
         }

      }
   }


}