package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.todoapp.data.Categorie
import com.example.todoapp.ui.common.SimpleCard


@Composable
fun MainScreen(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier.padding(paddingValues),
        verticalArrangement =  Arrangement.spacedBy(12.dp)
    ) {

         FirstComponent()

        SecondComponent()

        //ThirdComponent()




    }
}

@Composable
fun ThirdComponent() {
    TODO("Not yet implemented")
}

@Composable
fun FirstComponent() {
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
            Icon(Icons.Default.Face, contentDescription = "face")

        }

    }
}

@Composable
fun SecondComponent() {
    val categories = listOf(
        Categorie("Today",icon = Icons.Default.FavoriteBorder, 6,Color(0xFFa9def9 )),
        Categorie("Scheduled",icon = Icons.Default.FavoriteBorder, 5, Color(0xFFffe97f)),
        Categorie("All",icon = Icons.Default.FavoriteBorder, 14, Color(0xFFd0f4de)),
        Categorie("Overdue",icon = Icons.Default.FavoriteBorder, 3, Color(0xFFffc8dd) )

    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
      .padding(15.dp, 3.dp)

        ) {
        items(4) {index ->

            SimpleCard(
                categories[index].name,
                categories[index].icon,
                categories[index].count,
                categories[index].color

            )

        }
    }
}