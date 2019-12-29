package com.github.amin.todolist.ui.screens

import com.github.amin.todolist.model.TaskModel

interface MainContract {
    interface Views {
        fun setupViews()
        fun setupListeners()
        fun getTask(): TaskModel
        fun addTaskToDatabase(model: TaskModel)
        fun deleteTaskFromDatabase(model: TaskModel)
        fun getAllTasksFromDatabase(): List<TaskModel>
        fun addTaskList(list: ArrayList<TaskModel>)
        fun addTask(model: TaskModel)
    }

    interface Actions {
        fun initScreen()
        fun addTask()
        fun addTaskToDatabase()
        fun fetchAllTasks()
    }
}