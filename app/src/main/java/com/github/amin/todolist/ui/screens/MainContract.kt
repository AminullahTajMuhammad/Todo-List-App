package com.github.amin.todolist.ui.screens

import com.github.amin.todolist.model.TaskModel

interface MainContract {
    interface Views {
        fun setupViews()
        fun setupListeners()
        fun getTask(): TaskModel
        fun addItems(model: TaskModel)
    }

    interface Actions {
        fun initScreen()
        fun addTask()
    }
}