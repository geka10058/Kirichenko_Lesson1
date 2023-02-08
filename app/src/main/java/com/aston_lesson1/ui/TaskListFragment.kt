package com.aston_lesson1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aston_lesson1.R
import com.aston_lesson1.databinding.FragmentTaskListBinding

class TaskListFragment: Fragment(R.layout.fragment_task_list) {

    private var _binding: FragmentTaskListBinding? = null
    private val binding get() = requireNotNull(_binding)

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

        binding.apply {

            fabAddTask.setOnClickListener {
                val action = TaskListFragmentDirections.actionTaskFragmentToTaskFragment2()
                findNavController().navigate(action)
            }
        }
    }
}