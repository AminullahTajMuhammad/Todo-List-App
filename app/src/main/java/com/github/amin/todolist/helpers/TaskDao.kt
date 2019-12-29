package com.github.amin.todolist.helpers

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.amin.todolist.model.TaskModel

@Dao
interface TaskDao {
    @Query("select * from todo_table")
    fun getAllTask(): List<TaskModel>

    @Insert
    fun addTask(myTask: TaskModel)

    @Delete
    fun deleteTask(myTask: TaskModel)

}