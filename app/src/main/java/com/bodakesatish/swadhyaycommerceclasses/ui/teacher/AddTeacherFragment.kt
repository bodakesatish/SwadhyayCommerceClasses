package com.bodakesatish.swadhyaycommerceclasses.ui.teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddTeacherBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentTeacherListBinding
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

        binding?.btnAdd?.setOnClickListener {
            viewModel.addTeacher(
                Teacher(
                    0,
                    binding?.evFirstName?.text.toString(),
                    binding?.evMiddleName?.text.toString(),
                    binding?.evLastName?.text.toString(),
                    binding?.evTeacherDesignation?.text.toString(),
                    binding?.evTeacherQualification?.text.toString(),
                    Date(),
                    binding?.evTeacherExperience?.text.toString().toInt(),
                    binding?.evTeacherGender?.text.toString(),
                    Date(),
                    binding?.evPhoneNumber?.text.toString(),
                    binding?.evEmail?.text.toString(),
                    binding?.evSalary?.text.toString().toInt(),
                    true//binding?.evStatus?.text.toString()
                )
            )
        }

    }


}