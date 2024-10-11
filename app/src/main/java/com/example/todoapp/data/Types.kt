package com.example.todoapp.data

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


data class Task(
    val id : Int,
    val title : String,
    val description: String,
    val isCompleted : Boolean,
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