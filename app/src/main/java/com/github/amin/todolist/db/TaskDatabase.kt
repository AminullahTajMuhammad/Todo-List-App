package com.github.amin.todolist.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.amin.todolist.helpers.TaskDao
import com.github.amin.todolist.model.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    companion object {
        val DB_NAME = "task_db"
        var instance: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, TaskDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as TaskDatabase
        }
    }
    abstract fun taskDao(): TaskDao

}