package com.github.amin.todolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class TaskModel(
    @PrimaryKey
    var id: Long,

    @ColumnInfo(name = "task")
    var task: String
)