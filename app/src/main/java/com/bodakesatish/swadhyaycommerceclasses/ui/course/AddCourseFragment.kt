package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.common.DateHelper
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddCourseBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.CourseRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

@AndroidEntryPoint
class AddCourseFragment : Fragment() {

    private var binding: FragmentAddCourseBinding? = null
    private val viewModel: AddCourseViewModel by viewModels()
    private lateinit var course: Course

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddCourseBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpHeader()
        initData()

        binding?.btnAdd?.setOnClickListener {

            if (binding?.evCourseName?.editText?.text.isNullOrEmpty()) {
                binding?.evCourseName?.editText?.requestFocus()
                Toast.makeText(requireContext(), "Please enter course name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.addCourse(
                    Course(
                        0,
                        binding?.evCourseName?.editText?.text.toString(),
                        binding?.evCourseDuration?.editText?.text.toString(),
                        0,
                        binding?.evCourseDescription?.editText?.text.toString(),
                        Date(),
                        Date()
                    )
                )
            }

        }

        binding?.evCalendarCourseStartDate?.setOnClickListener {
            courseStartDatePicker()
        }

        binding?.evCalendarCourseEndDate?.setOnClickListener {
            courseEndDatePicker()
        }

        binding?.btnCourseSubject?.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt(Constants.COURSE_ID, course.courseId)
            findNavController().navigate(R.id.subject_list_dest, bundle)
        }

        viewModel.courseResponse.observe(viewLifecycleOwner) {
            course.courseId = it.data.toString().toInt()
            Toast.makeText(requireContext(), "Course Id : ${course.courseId} added successfully", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initData() {
        course = Course(0, "", "", 0, "", Date(), Date())
        binding?.evCourseName?.editText?.setText(course.courseName)
        binding?.evCourseDescription?.editText?.setText(course.courseDescription)
        binding?.evCourseDuration?.editText?.setText(course.courseDuration)
        binding?.evCourseStartDate?.editText?.setText(
            DateHelper.getFormattedDate(
                course.courseStartDate,
                DateHelper.DATE_FORMAT_dd_MMM_yyyy
            )
        )
        binding?.evCourseEndDate?.editText?.setText(
            DateHelper.getFormattedDate(
                course.courseEndDate,
                DateHelper.DATE_FORMAT_dd_MMM_yyyy
            )
        )
    }

    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Add Course"
    }

    private fun courseStartDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(course.courseStartDate.time)
            .build()

        datePicker.show(childFragmentManager, "")
        datePicker.addOnPositiveButtonClickListener { selection ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selection
            course.courseStartDate = calendar.time
            val formattedDate =
                DateHelper.getFormattedDate(calendar.time, DateHelper.DATE_FORMAT_dd_MMM_yyyy)

            Toast.makeText(requireContext(), "Selected Date: $formattedDate", Toast.LENGTH_SHORT)
                .show()
            binding?.evCourseStartDate?.editText?.setText(formattedDate)
        }
    }

    private fun courseEndDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(course.courseEndDate.time)
            .build()

        datePicker.show(childFragmentManager, "")
        datePicker.addOnPositiveButtonClickListener { selection ->
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = selection
            course.courseEndDate = calendar.time
            val formattedDate =
                DateHelper.getFormattedDate(calendar.time, DateHelper.DATE_FORMAT_dd_MMM_yyyy)
            Toast.makeText(requireContext(), "Selected Date: $formattedDate", Toast.LENGTH_SHORT)
                .show()
            binding?.evCourseStartDate?.editText?.setText(formattedDate)
        }
    }


}