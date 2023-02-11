package com.aston_lesson1.ui.task_add_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aston_lesson1.data.Task
import com.aston_lesson1.data.TaskRepo

class TaskAddVM(private val taskRepo: TaskRepo):ViewModel() {

    fun saveTaskToDB(task:Task) {
        taskRepo.insertTask(task)
    }

}

class TaskAddVMFactory(
    private val taskRepo: TaskRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskAddVM::class.java)) {
            return TaskAddVM(
                taskRepo
            ) as T
        }
        throw IllegalArgumentException("unknown VM class")
    }
}