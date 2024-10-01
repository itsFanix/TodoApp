package com.example.todoapp.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.R


@SuppressLint("InvalidColorHexValue")
@Composable
fun ItemCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
        ,
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        )

    ) {
       Row(
           modifier = Modifier
               .padding(8.dp)
               .fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ) {
           Row (
               horizontalArrangement = Arrangement.spacedBy(8.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Box(
                   modifier = Modifier
                       .size(40.dp)
                       .clip(CircleShape)
                       .background(MaterialTheme.colorScheme.onSecondary),
                   Alignment.Center

               ) {
                   CheckBoxCustom()
               }
               Column (
                   verticalArrangement = Arrangement.spacedBy(4.dp),


               ) {
                   Row (
                       horizontalArrangement = Arrangement.spacedBy(15.dp)
                   ) {
                       //Today component
                       Row (
                           horizontalArrangement = Arrangement.spacedBy(2.dp),
                           verticalAlignment = Alignment.CenterVertically) {

                           Icon(
                               imageVector = Icons.Default.DateRange,
                               "Today",
                               tint = Color(0xFFadb5bd),
                               modifier = Modifier
                                   .size(12.dp)
                           )
                           Text(
                               "Today",
                               color = Color(0xFFadb5bd),
                               style = MaterialTheme.typography.titleSmall
                           )
                       }
                       // Hour Component

                       Row (
                           horizontalArrangement = Arrangement.spacedBy(2.dp),
                           verticalAlignment = Alignment.CenterVertically) {
                           Icon(
                               imageVector = Icons.Default.Favorite,
                               "Hour",
                               tint = Color(0xFFadb5bd),
                               modifier = Modifier
                                   .size(12.dp)
                               )
                           Text(
                               //Todo After implement The ViewModel
                               "4:50 PM",
                               color = Color(0xFFadb5bd),
                               style = MaterialTheme.typography.titleSmall

                           )
                       }

                   }
                   Text("Todo Name ",
                       modifier = Modifier.padding(2.dp)
                   )

               }
           }

           Box(
               modifier = Modifier
                   .size(30.dp)
                   .clip(CircleShape)
                   .background(MaterialTheme.colorScheme.onSecondary),
               Alignment.Center

           ) {
               /**
                *Implement Action Button 
                */
               Icon(imageVector = ImageVector.vectorResource(R.drawable.more_horiz), "action")
           }
       }

    }
}

@Preview(showBackground = false)
@Composable
fun itemCardPreview() {
    ItemCard()
}