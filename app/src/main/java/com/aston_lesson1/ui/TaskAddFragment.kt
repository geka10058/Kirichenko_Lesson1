package com.aston_lesson1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aston_lesson1.R
import com.aston_lesson1.data.Task
import com.aston_lesson1.databinding.FragmentAddTaskBinding

class TaskAddFragment : Fragment(R.layout.fragment_add_task) {

    private var _binding: FragmentAddTaskBinding? = null
    private val binding get() = requireNotNull(_binding)
    private var task = Task()
    private var title = ""
    private var description = ""

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

            etTaskTitle.addTextChangedListener {
                title = it.toString()
                task.title = title
            }

            etTaskDescription.addTextChangedListener {
                description = it.toString()
                task.description = description
            }

            fabSaveTask.setOnClickListener {

                    when {
                        title =="" && description == "" ->{
                            Toast.makeText(
                                requireContext(),
                                "You didn't fill in the fields",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        task.title == "" -> {
                            Toast.makeText(
                                requireContext(),
                                "Title field is empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        task.description == "" -> {
                            Toast.makeText(
                                requireContext(),
                                "Description field is empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            val action =
                                TaskAddFragmentDirections.actionTaskFragment2ToTaskFragment(task)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }