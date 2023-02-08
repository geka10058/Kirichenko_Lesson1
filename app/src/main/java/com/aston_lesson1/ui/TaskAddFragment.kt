package com.aston_lesson1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aston_lesson1.R
import com.aston_lesson1.databinding.FragmentAddTaskBinding

class TaskAddFragment: Fragment(R.layout.fragment_add_task) {

    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentAddTaskBinding.bind(view)

        binding.apply {

            fabSaveTask.setOnClickListener {
                val action = TaskAddFragmentDirections.actionTaskFragment2ToTaskFragment()
                findNavController().navigate(action)
            }
        }
    }
}