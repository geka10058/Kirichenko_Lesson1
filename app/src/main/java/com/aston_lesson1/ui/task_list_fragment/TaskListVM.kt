package com.aston_lesson1.ui.task_list_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.aston_lesson1.data.Task
import com.aston_lesson1.data.TaskRepo

class TaskListVM(private val taskRepo: TaskRepo):ViewModel() {

    val taskListLD:LiveData<List<Task>> = taskRepo.taskFlow.asLiveData()

}

class TaskListVMFactory(
    private val taskRepo: TaskRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskListVM::class.java)) {
            return TaskListVM(
                taskRepo
            ) as T
        }
        throw IllegalArgumentException("unknown VM class")
    }
}