package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddStudentBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddTeacherBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentTeacherListBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AddStudentFragment : Fragment() {

    private var binding: FragmentAddStudentBinding? = null
    private val viewModel: AddStudentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnAdd?.setOnClickListener {
            viewModel.addStudent(
                Student(
                    0,
                    1,
                    binding?.evFirstName?.text.toString(),
                    binding?.evMiddleName?.text.toString(),
                    binding?.evLastName?.text.toString(),
                    Date(),
                    binding?.evStudentGender?.text.toString(),
                    binding?.evStudentAddress?.text.toString(),
                    binding?.evPhoneNumber?.text.toString(),
                    binding?.evEmail?.text.toString(),
                    binding?.evParentName?.text.toString(),
                    binding?.evParentPhoneNumber?.text.toString(),
                    Date(),
                    true//binding?.evStatus?.text.toString()
                )
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}