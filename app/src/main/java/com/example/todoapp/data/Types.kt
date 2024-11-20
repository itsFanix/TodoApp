package com.example.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


/**
 * Les atributs d'une tâche
 * un id unique
 * un titre et ou une description
 * un status pour indiquer si elle est terminée
 * une date
 * une heure
 * priorité
 * catégorie
 * date de création
 * On peut sauvegarder les catégories dans une BDD
 */

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title : String,
    val description: String,
    var isCompleted : Boolean = false,
    val date : LocalDate?,
    val time : LocalTime?,
    val creationDate : LocalDateTime,
    val category: String,
    val priority: Priority,
)
enum class Priority {
    HIGH,
    MEDIUM,
    LOW
}