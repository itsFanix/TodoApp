package com.example.todoapp.data

import android.content.Context
import androidx.room.Room


//To create and initialize the Room databasen you'll typically use the Room.databaseBuilder() method
object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context) : AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase:: class.java,
                "task_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}