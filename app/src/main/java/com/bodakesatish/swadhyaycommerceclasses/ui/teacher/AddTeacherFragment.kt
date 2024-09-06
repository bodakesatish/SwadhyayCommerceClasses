package com.bodakesatish.swadhyaycommerceclasses.ui.teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddTeacherBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AddTeacherFragment : Fragment() {

    private var binding: FragmentAddTeacherBinding? = null
    private val viewModel: AddTeacherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTeacherBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpHeader()
        initListeners()
        initObservers()

    }

    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Add Teacher"
    }

    private fun initListeners() {

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.btnAdd?.setOnClickListener {
            viewModel.addTeacher(
                Teacher(
                    0,
                    binding?.evFirstName?.editText?.text.toString(),
                    binding?.evMiddleName?.editText?.text.toString(),
                    binding?.evLastName?.editText?.text.toString()
//                    binding?.evTeacherDesignation?.text.toString(),
//                    binding?.evTeacherQualification?.text.toString(),
//                    Date(),
//                    binding?.evTeacherExperience?.text.toString().toInt(),
//                    binding?.evTeacherGender?.text.toString(),
//                    Date(),
//                    binding?.evPhoneNumber?.text.toString(),
//                    binding?.evEmail?.text.toString(),
//                    binding?.evSalary?.text.toString().toInt(),
//                    true//binding?.evStatus?.text.toString()
                )
            )
        }

    }

    private fun initObservers() {
        viewModel.addTeacherResponse.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
    }

    }