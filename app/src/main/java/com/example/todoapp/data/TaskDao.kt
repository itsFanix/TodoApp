package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


//DAO Responsable d'interagir directement avec la base de données
//Le repository sert d'intermédiaire entre le DAO et le ViewModel
//Le repository encapsule la logique d'accès aux données et peut agréger plusieurs sources de données

@Dao
interface TaskDao {
    //get all Task
    @Query("SELECT * FROM tasks ORDER BY creationDate DESC")
    fun getAllTasks(): Flow<List<Task>>

    //Insert new Task
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertTask(task: Task)

    //Update a task
    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun  deleteTask(task: Task)

    //Delete all the tasks
    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()


}