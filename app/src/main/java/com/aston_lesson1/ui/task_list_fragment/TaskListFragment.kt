package com.aston_lesson1.ui.task_list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aston_lesson1.R
import com.aston_lesson1.TaskApplication
import com.aston_lesson1.data.Task
import com.aston_lesson1.databinding.FragmentTaskListBinding
import com.aston_lesson1.ui.OnItemClickListener
import com.aston_lesson1.ui.TasksAdapter

class TaskListFragment : Fragment(R.layout.fragment_task_list), OnItemClickListener {


    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = requireNotNull(_binding)
    private val viewModel: TaskListVM by viewModels {
        TaskListVMFactory((activity?.application as TaskApplication).taskRepo)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTaskListBinding.bind(view)
        val tasksAdapter = TasksAdapter(this)

        /*task?.let {
        Log.d("TAG", "TASK: $it")
            val list = listOf<Task>(it)
            taskList.postValue(list) }*/

        binding.apply {
            recyclerViewTask.apply {
                adapter = tasksAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            fabAddTask.setOnClickListener {
                val action = TaskListFragmentDirections.actionTaskFragmentToTaskFragment2()
                findNavController().navigate(action)
            }
        }

        viewModel.taskListLD.observe(viewLifecycleOwner) {
            tasksAdapter.submitList(it!!)
        }
    }

    override fun onItemClick(task: Task) {

    }
}