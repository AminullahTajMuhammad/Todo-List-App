package com.github.amin.todolist.ui.screens

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.amin.todolist.R
import com.github.amin.todolist.adapters.TaskAdapter
import com.github.amin.todolist.db.TaskDatabase
import com.github.amin.todolist.listeners.ItemClickListener
import com.github.amin.todolist.model.TaskModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), MainContract.Views {

    lateinit var presenter: MainPresenter
    lateinit var mAdapter: TaskAdapter
    lateinit var db: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = TaskDatabase.getInstance(this)
        presenter = MainPresenter(this)

    }

    override fun setupViews() {
        mAdapter = TaskAdapter(this, object : ItemClickListener {
            override fun itemClick(position: Int) {
                db.taskDao().deleteTask(mAdapter.taskList[position])
                mAdapter.deleteItem(position)
            }
        })
        task_recycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = mAdapter
        }
    }

    override fun setupListeners() {
        btn_add_task.setOnClickListener {
            val task = edt_write_text.text.toString()
            if(task.equals("")) {
                Toast.makeText(applicationContext, "Write a task", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                presenter.addTaskToDatabase()
                presenter.addTask()
                edt_write_text.setText("")
            }
        }
    }

    override fun addTask(model: TaskModel) {
        mAdapter.addItem(model)
    }

    override fun addTaskList(list: ArrayList<TaskModel>) {
        mAdapter.setItem(list)
    }

    override fun getTask(): TaskModel {
        return TaskModel(
            Random.nextLong(),
            edt_write_text.text.toString()
        )
    }

    // add item in database table
    override fun addTaskToDatabase(model: TaskModel) {
        db.taskDao().addTask(model)
    }

    override fun deleteTaskFromDatabase(model: TaskModel) {
        db.taskDao().deleteTask(model)
    }

    override fun getAllTasksFromDatabase(): List<TaskModel> {
        return db.taskDao().getAllTask()
    }
}