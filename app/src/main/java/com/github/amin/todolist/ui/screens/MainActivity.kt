package com.github.amin.todolist.ui.screens

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.amin.todolist.R
import com.github.amin.todolist.adapters.TaskAdapter
import com.github.amin.todolist.listeners.ItemClickListener
import com.github.amin.todolist.model.TaskModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.Views {

    lateinit var presenter: MainPresenter
    lateinit var mAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

    }

    override fun setupViews() {
        mAdapter = TaskAdapter(this, object : ItemClickListener {
            override fun itemClick(position: Int) {
                Toast.makeText(applicationContext, "You Clicked this $position", Toast.LENGTH_SHORT).show()
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
                presenter.addTask()
                edt_write_text.setText("")
            }
        }
    }

    override fun addItems(model: TaskModel) {
        mAdapter.addItem(model)
    }

    override fun getTask(): TaskModel {
        return TaskModel(
            edt_write_text.text.toString()
        )
    }
}