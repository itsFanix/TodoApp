package com.example.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Task::class], version = 1) //Define entities that belong to the database and the version of the database
@TypeConverters(Converters::class) //Register a converter in the database
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao() : TaskDao //provides access to the DAO
}