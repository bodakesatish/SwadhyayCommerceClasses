package com.bodakesatish.swadhyaycommerceclasses.ui.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminDashboardFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentAdminDashboardBinding
    private val viewModel: AdminDashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAdminDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpHeader()

        binding.apply {
            cvCourse.setOnClickListener(this@AdminDashboardFragment)
            cvBatch.setOnClickListener(this@AdminDashboardFragment)
            cvTeacher.setOnClickListener(this@AdminDashboardFragment)
            cvStudents.setOnClickListener(this@AdminDashboardFragment)
            cvExams.setOnClickListener(this@AdminDashboardFragment)
            cvFees.setOnClickListener(this@AdminDashboardFragment)
            cvAttendance.setOnClickListener(this@AdminDashboardFragment)

        }
    }

    private fun setUpHeader() {
        binding.headerGeneric.tvHeader.text = "Admin Dashboard"
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.cv_course -> {
                findNavController().navigate(R.id.course_list_dest)
            }
            R.id.cv_batch -> {
                findNavController().navigate(R.id.batch_list_dest)
            }
            R.id.cv_teacher -> {
                findNavController().navigate(R.id.teacher_list_dest)
            }
            R.id.cv_students -> {
                findNavController().navigate(R.id.student_list_dest)
            }
            R.id.cv_exams -> {
                findNavController().navigate(R.id.exam_list_dest)
            }
            R.id.cv_fees -> {
                findNavController().navigate(R.id.fees_dest)
            }
            R.id.cv_attendance -> {

            }

        }
    }


}