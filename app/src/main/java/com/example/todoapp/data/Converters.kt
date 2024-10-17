package com.example.todoapp.data

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromPriority(priority: Priority) : String {
        return priority.name //convert Enum to String
    }
    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority) //convert String back to Enum
    }
}