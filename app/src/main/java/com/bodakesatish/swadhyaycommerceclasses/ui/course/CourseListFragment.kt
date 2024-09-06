package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.course.adapter.CourseAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseListFragment : Fragment() {

    private var binding: FragmentCourseListBinding? = null

    private val viewModel: CourseListViewModel by viewModels()

    private var courseAdapter: CourseAdapter = CourseAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCourseListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpHeader()

        initView()

        initListeners()

        initObservers()

        fetchCourseList()

    }

    private fun fetchCourseList() {
        viewModel.getCourseList()
    }

    private fun initObservers() {
        viewModel.courseResponse.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        courseAdapter.setData(it)
                    }
                }

                else -> {
                    courseAdapter.setData(emptyList())
                }
            }

        }
    }

    private fun initListeners() {

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.btnNewCourse?.setOnClickListener {
            findNavController().navigate(R.id.add_course_dest)
        }

        courseAdapter.setOnClickListener { course ->
            val action = CourseListFragmentDirections.actionFragmentCourseListToFragmentSubjectList(course)
            findNavController().navigate(action)
        }
    }

    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Course List"
    }

    private fun initView() {
        binding?.rvCourseList?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvCourseList?.adapter = courseAdapter
        binding?.rvCourseList?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}