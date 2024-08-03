package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentStudentAttendanceBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentTeacherAttendanceBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.teacher.TeacherAttendanceViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentAttendanceFragment : Fragment() {

    private var binding: FragmentStudentAttendanceBinding? = null
    private val viewModel: StudentAttendanceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentAttendanceBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}