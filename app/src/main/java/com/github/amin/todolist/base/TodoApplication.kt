package com.github.amin.todolist.base

import android.app.Application
import com.facebook.stetho.Stetho

class TodoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}