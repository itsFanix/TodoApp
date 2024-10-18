package com.example.todoapp.data

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class Converters {
    private val dateFormatter : DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
    private val timeFormatter : DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME
    private  val dateTimeFormatter : DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    @TypeConverter
    fun fromPriority(priority: Priority) : String {
        return priority.name //convert Enum to String
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority) //convert String back to Enum
    }

    @TypeConverter
    fun fromLocalDate(date: LocalDate) : String {
        return date.format(dateFormatter)
    }

    @TypeConverter
    fun toLocalDate(dateString: String) : LocalDate {
        return LocalDate.parse(dateString, dateFormatter)
    }

    @TypeConverter
    fun fromLocalTime(time: LocalTime) :String {
        return time.format(timeFormatter)
    }

    @TypeConverter
    fun toLocalTime(timeString: String): LocalTime {
        return LocalTime.parse(timeString, timeFormatter)
    }

    @TypeConverter
    fun fromLocateDateTime(dateTime : LocalDateTime) : String {
        return dateTime.format(dateTimeFormatter)
    }

    @TypeConverter
    fun toLocateDateTime(dateTimeString : String) : LocalDateTime {
        return LocalDateTime.parse(dateTimeString, dateTimeFormatter)
    }

}