package com.github.amin.todolist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.github.amin.todolist.R
import com.github.amin.todolist.listeners.ItemClickListener
import com.github.amin.todolist.model.TaskModel

class TaskAdapter(var context: Context, var itemClick: ItemClickListener): RecyclerView.Adapter<TaskAdapter.Holder>() {

    var taskList = arrayListOf<TaskModel>()

    fun setItem(items: ArrayList<TaskModel>) {
        this.taskList.clear()
        this.taskList.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(model: TaskModel) {
        this.taskList.add(model)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item_task, parent, false)
        return Holder(itemView = itemView)
    }

    override fun getItemCount(): Int {
        return this.taskList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tv_task.text = taskList[position].task
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tv_task = itemView.findViewById<AppCompatTextView>(R.id.tv_task)
        val btn_delete = itemView.findViewById<AppCompatImageButton>(R.id.btn_delete)
        init {
            btn_delete.setOnClickListener {
                taskList.remove(taskList[adapterPosition])
                notifyItemRemoved(adapterPosition)
            }
            itemView.setOnClickListener { view ->
                itemClick.itemClick(adapterPosition)
            }
        }
    }
}