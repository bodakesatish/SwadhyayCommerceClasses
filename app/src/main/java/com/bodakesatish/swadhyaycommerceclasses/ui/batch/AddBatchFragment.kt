package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.bodakesatish.swadhyaycommerceclasses.data.common.DateHelper
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentAddBatchBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.ItemLayoutBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.util.AppArrayAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.AppDatePicker
import com.bodakesatish.swadhyaycommerceclasses.util.AppListPopupWindow
import com.bodakesatish.swadhyaycommerceclasses.util.AppTimePicker
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBatchFragment : Fragment() {

    private var binding: FragmentAddBatchBinding? = null
    private val viewModel: AddBatchViewModel by viewModels()

    private lateinit var batch: Batch
    private var courseList: List<Course> = emptyList()
    private var subjectList: List<Subject> = emptyList()
    private var teacherList: List<Teacher> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBatchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHeader()
        initObservers()
        initListeners()
        initData()

    }

    private fun initData() {
        batch = Batch()
        viewModel.getCourseList()
        viewModel.getTeacherList()
    }

    private fun initListeners() {

        binding?.evBatchStartTime?.editText?.setOnClickListener {
            showBatchStartTimePicker()
        }

        binding?.evBatchStartDate?.editText?.setOnClickListener {
            batchStartDatePicker()
        }

        binding?.evBatchEndDate?.editText?.setOnClickListener {
            batchEndDatePicker()
        }

        binding?.evBatchEndTime?.editText?.setOnClickListener {
            showBatchEndTimePicker()
        }

        binding?.evCoursesList?.editText?.setOnClickListener {
            showCoursesList(it)
        }

        binding?.evSubjectList?.editText?.setOnClickListener {
            showSubjectList(it)
        }

        binding?.evTeacherList?.editText?.setOnClickListener {
            showTeacherList(it)
        }

        binding?.btnAdd?.setOnClickListener {
            batch.batchTitle = binding?.evBatchTitle?.editText?.text.toString()
            viewModel.addBatch(batch)
        }

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun initHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Add New Batch"
    }

    private fun initObservers() {

        viewModel.batchResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(),
                        "Batch Added Successfully",Toast.LENGTH_SHORT).show()
                    findNavController().popBackStack()
                }

                else -> {
                   Toast.makeText(requireContext(),
                       "Something went wrong",Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.courseResponse.observe(viewLifecycleOwner) { response ->

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

        viewModel.teacherResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        teacherList = it
                    }
                }

                else -> {
                    teacherList = emptyList()
                }
            }
        }

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
            binding?.evCoursesList?.editText?.setText(courseList[position].courseName)
            batch.courseId = courseList[position].courseId
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
                batch.subjectId = subjectList[position].subjectId
            }

        }

    }

    private fun showTeacherList(anchorView: View) {

        val appArrayAdapter = AppArrayAdapter(requireContext(), teacherList) {
                listBinding: ViewBinding, teacher: Teacher ->
            (listBinding as ItemLayoutBinding).itemNameTextView.text = teacher.teacherFirstName + "" + teacher.teacherLastName
        }

        AppListPopupWindow.showListPopupWindow(
            anchorView, appArrayAdapter ) { position ->
            batch.teacherId = teacherList[position].teacherId
            binding?.evTeacherList?.editText?.setText(
                "${teacherList.get(position).teacherFirstName} ${teacherList.get(position).teacherLastName}"
            )
        }

    }

    private fun showBatchStartTimePicker() {

        AppTimePicker.showTimePicker(
            parentFragmentManager,
            batch.batchStartTime,
            "Select Batch Start Time",
        ) { selectedTime, formattedTime -> // Handle the selected time here
            batch.batchStartTime = selectedTime.time
            binding?.evBatchStartTime?.editText?.setText(formattedTime)
        }

    }

    private fun showBatchEndTimePicker() {

        AppTimePicker.showTimePicker(
            parentFragmentManager,
            batch.batchEndTime,
            "Select Batch End Time",
        ) { selectedTime, formattedTime -> // Handle the selected time here
            batch.batchEndTime = selectedTime.time
            binding?.evBatchEndTime?.editText?.setText(formattedTime)
        }

    }

    private fun batchStartDatePicker() {

        AppDatePicker.showDatePicker(
            parentFragmentManager,
            batch.batchStartDate,
            "Select Batch Start Date",
        ) { selectedDate, formattedDate -> // Handle the selected time here
            batch.batchStartDate = DateHelper.formatDate(selectedDate.time)
            binding?.evBatchStartDate?.editText?.setText(formattedDate)
        }

    }


    private fun batchEndDatePicker() {

        AppDatePicker.showDatePicker(
            parentFragmentManager,
            batch.batchStartDate,
            "Select Batch End Date",
        ) { selectedDate, formattedDate -> // Handle the selected time here
            batch.batchEndDate = DateHelper.formatDate(selectedDate.time)
            binding?.evBatchEndDate?.editText?.setText(formattedDate)
        }

    }

}