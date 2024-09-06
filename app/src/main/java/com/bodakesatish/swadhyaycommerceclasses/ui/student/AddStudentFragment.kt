package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewbinding.ViewBinding
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.data.common.DateHelper
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddStudentBinding
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

@AndroidEntryPoint
class AddStudentFragment : Fragment() {

    private var binding: FragmentAddStudentBinding? = null
    private val viewModel: AddStudentViewModel by viewModels()

    private var courseList: List<Course> = emptyList()
    private var subjectList: List<Subject> = emptyList()
    private var batchList: List<Batch> = emptyList()
    private var student: Student = Student()
    val args: AddStudentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        args.student?.let {
            student = it
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(student.studentId > 0) {
            setUpStudentData()
        }
        Log.i(tag, "onViewCreated -> $student")

        initHeader()
        initListeners()
        initObservers()
        initData()

    }

    private fun setUpStudentData() {
        student.apply {
            with(binding) {
                this?.evFirstName?.editText?.setText(student.studentFirstName)
                this?.evMiddleName?.editText?.setText(student.studentMiddleName)
                this?.evLastName?.editText?.setText(student.studentLastName)
                this?.evCoursesList?.editText?.setText("CID:${student.courseId}")
            }
        }
    }

    private fun initData() {
        viewModel.getCourseList()
    }

    private fun initObservers() {
        viewModel.addStudentResponse.observe(viewLifecycleOwner) {
            findNavController().popBackStack()
        }
        viewModel.deleteStudentResponse.observe(viewLifecycleOwner) {
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

            student.studentFirstName = binding?.evFirstName?.editText?.text.toString()
            student.studentMiddleName = binding?.evMiddleName?.editText?.text.toString()
            student.studentLastName = binding?.evLastName?.editText?.text.toString()
//                    Date(),
//                    binding?.evStudentGender?.text.toString(),
//                    binding?.evStudentAddress?.text.toString(),
//                    binding?.evPhoneNumber?.text.toString(),
//                    binding?.evEmail?.text.toString(),
//                    binding?.evParentName?.text.toString(),
//                    binding?.evParentPhoneNumber?.text.toString(),
//                    Date(),
//                    true//binding?.evStatus?.text.toString()
            viewModel.addOrUpdateStudent(student)

        }

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        binding?.headerGeneric?.btnDelete?.setOnClickListener {
            Log.i(tag, "Delete clicked $student")
            viewModel.deleteStudent(student = student)
        }

    }

    private fun initHeader() {
        if(student.studentId > 0) {
            binding?.headerGeneric?.tvHeader?.text = getString(R.string.update_student)
            binding?.btnAdd?.text = getString(R.string.update)
            binding?.headerGeneric?.btnDelete?.visibility = View.VISIBLE
        } else {
            binding?.headerGeneric?.tvHeader?.text = getString(R.string.add_student)
        }
    }

    private fun showCoursesList(anchorView: View) {

        val appArrayAdapter = AppArrayAdapter(
            requireContext(),
            courseList
        ) { listBinding: ViewBinding, course: Course ->
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

            val appArrayAdapter = AppArrayAdapter(
                requireContext(),
                subjectList
            ) { listBinding: ViewBinding, subject: Subject ->
                (listBinding as ItemLayoutBinding).itemNameTextView.text = subject.subjectName
            }

            AppListPopupWindow.showListPopupWindow(
                anchorView,
                appArrayAdapter
            ) { position ->
                binding?.evSubjectList?.editText?.setText(subjectList[position].subjectName)
                viewModel.getFilteredBatchList(student.courseId, subjectList[position].subjectId)
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

            val appArrayAdapter = AppArrayAdapter(
                requireContext(),
                batchList
            ) { listBinding: ViewBinding, batch: Batch ->
                (listBinding as ItemLayoutBinding).itemNameTextView.text =
                    "${DateHelper.formatTime(batch.batchStartTime)} - ${DateHelper.formatTime(batch.batchEndTime)}"
            }

            AppListPopupWindow.showListPopupWindow(
                anchorView,
                appArrayAdapter
            ) { position ->
//                student = subjectList[position].subjectId
                binding?.evBatchTime?.editText?.setText(
                    "${DateHelper.formatTime(batchList[position].batchStartTime)} - ${
                        DateHelper.formatTime(
                            batchList[position].batchEndTime
                        )
                    }"
                )
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}