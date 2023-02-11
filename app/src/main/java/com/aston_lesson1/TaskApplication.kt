package com.aston_lesson1

import android.app.Application
import com.aston_lesson1.data.ApplicationDatabase
import com.aston_lesson1.data.TaskRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class TaskApplication: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    private val database by lazy { ApplicationDatabase.getDatabase(this, applicationScope) }
    val taskRepo by lazy {TaskRepo(database.taskDao())}
}