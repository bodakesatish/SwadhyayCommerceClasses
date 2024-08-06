package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.DateHelper
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddStudentBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddTeacherBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAdminDashboardBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentLoginBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentTeacherListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.ItemLayoutBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.util.AppArrayAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.AppListPopupWindow
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.util.Date

@AndroidEntryPoint
class AddStudentFragment : Fragment() {

    private var binding: FragmentAddStudentBinding? = null
    private val viewModel: AddStudentViewModel by viewModels()

    private var courseList: List<Course> = emptyList()
    private var subjectList: List<Subject> = emptyList()
    private var batchList: List<Batch> = emptyList()
    private lateinit var student : Student

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHeader()
        initListeners()
        initObservers()
        initData()

    }

    private fun initData() {
        student = Student(0, 0, "", "", "", Date(), "", "", "", "", "", "", Date(), true)
        viewModel.getCourseList()
    }

    private fun initObservers() {
        viewModel.addStudentResponse.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
        viewModel.courseResponse.observe(viewLifecycleOwner) { response ->
            // Handle the course list response
            // Update the UI or perform any necessary actions
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        courseList = it
                    }
                }

                else -> {
                    courseList = emptyList()
                }
            }
        }
        viewModel.subjectResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        subjectList = it
                    }
                }

                else -> {
                    subjectList = emptyList()
                }
            }
        }
        viewModel.filteredBatchListResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        batchList = it
                    }
                }

                else -> {
                    batchList = emptyList()
                }
            }
        }
    }

    private fun initListeners() {
        binding?.evCoursesList?.editText?.setOnClickListener {
            showCoursesList(it)
        }

        binding?.evSubjectList?.editText?.setOnClickListener {
            showSubjectList(it)
        }
        binding?.evBatchTime?.editText?.setOnClickListener {
            showBatchList(it)
        }

        binding?.btnAdd?.setOnClickListener {
//            viewModel.addStudent(
//                Student(
//                    0,
//                    1,
//                    binding?.evFirstName?.text.toString(),
//                    binding?.evMiddleName?.text.toString(),
//                    binding?.evLastName?.text.toString(),
//                    Date(),
//                    binding?.evStudentGender?.text.toString(),
//                    binding?.evStudentAddress?.text.toString(),
//                    binding?.evPhoneNumber?.text.toString(),
//                    binding?.evEmail?.text.toString(),
//                    binding?.evParentName?.text.toString(),
//                    binding?.evParentPhoneNumber?.text.toString(),
//                    Date(),
//                    true//binding?.evStatus?.text.toString()
//                )
//            )
        }

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initHeader() {
        binding?.headerGeneric?.tvHeader?.text = getString(R.string.add_student)
    }

    private fun showCoursesList(anchorView: View) {

        val appArrayAdapter = AppArrayAdapter(requireContext(), courseList) {
                listBinding: ViewBinding, course: Course ->
            (listBinding as ItemLayoutBinding).itemNameTextView.text = course.courseName
        }
        AppListPopupWindow.showListPopupWindow(
            anchorView,
            appArrayAdapter
        ) { position ->
            student.courseId = courseList[position].courseId
            binding?.evCoursesList?.editText?.setText(courseList[position].courseName)
            viewModel.getSubjectList(courseList[position].courseId)
            binding?.evSubjectList?.editText?.setText("")
        }

    }

    private fun showSubjectList(anchorView: View) {

        if (binding?.evCoursesList?.editText?.text?.isBlank() == true) {
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "Please select course before selecting subject",
                Snackbar.LENGTH_LONG
            ).show()
        } else {

            val appArrayAdapter = AppArrayAdapter(requireContext(), subjectList) {
                    listBinding: ViewBinding, subject: Subject ->
                (listBinding as ItemLayoutBinding).itemNameTextView.text = subject.subjectName
            }

            AppListPopupWindow.showListPopupWindow(
                anchorView,
                appArrayAdapter
            ) { position ->
                binding?.evSubjectList?.editText?.setText(subjectList[position].subjectName)
                viewModel.getFilteredBatchList(student.courseId,subjectList[position].subjectId)
            }

        }

    }

    private fun showBatchList(anchorView: View) {
        if (binding?.evSubjectList?.editText?.text?.isBlank() == true) {
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "Please select course and subject before selecting batch",
                Snackbar.LENGTH_LONG
            ).show()
        } else {

            val appArrayAdapter = AppArrayAdapter(requireContext(), batchList) {
                    listBinding: ViewBinding, batch: Batch ->
                (listBinding as ItemLayoutBinding).itemNameTextView.text = "${DateHelper.formatTime(batch.batchStartTime)} - ${DateHelper.formatTime(batch.batchEndTime)}"
            }

            AppListPopupWindow.showListPopupWindow(
                anchorView,
                appArrayAdapter
            ) { position ->
//                student = subjectList[position].subjectId
                binding?.evBatchTime?.editText?.setText("${DateHelper.formatTime(batchList[position].batchStartTime)} - ${DateHelper.formatTime(batchList[position].batchEndTime)}")
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}