package com.example.todoapp.data

import kotlinx.coroutines.flow.Flow


class TaskRepository(private val taskDao: TaskDao) {
    //get all task
    fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }

    //add new task
    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task)

    }

    //update a task
    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }

    //delete a task
    suspend fun  deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }

    //DeleteAll task
    suspend fun deleteAllTask(){
        taskDao.deleteAllTasks()

    }

}