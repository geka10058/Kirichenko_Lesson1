package com.aston_lesson1.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TaskRepo(private val taskDao: TaskDao) {

    private val scope = CoroutineScope((Dispatchers.IO))
    val taskFlow: Flow<List<Task>> = taskDao.getTaskList()

    fun insertTask(task:Task) = scope.launch { taskDao.insertTask(task) }

    fun onDestroyCoroutineScope() {
        scope.cancel()
    }
}