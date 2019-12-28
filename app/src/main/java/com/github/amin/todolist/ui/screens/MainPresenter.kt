package com.github.amin.todolist.ui.screens

import com.github.amin.todolist.model.TaskModel

class MainPresenter : MainContract.Actions {

    var _views: MainContract.Views? = null
    var list = arrayListOf<TaskModel>()

    constructor(_views: MainContract.Views?) {
        this._views = _views
        initScreen()
    }


    override fun initScreen() {
        _views?.setupViews()
        _views?.setupListeners()
    }

    override fun addTask() {
        _views?.addItems(_views?.getTask()!!)
    }
}