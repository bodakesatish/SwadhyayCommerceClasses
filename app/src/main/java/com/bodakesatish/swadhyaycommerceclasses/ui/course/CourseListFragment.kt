package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.cachedIn
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentCourseListBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.course.adapter.CourseAdapter
import com.bodakesatish.swadhyaycommerceclasses.ui.course.adapter.PagedCourseAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.cache
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CourseListFragment : Fragment() {

    private var binding: FragmentCourseListBinding? = null

    private val viewModel: CourseListViewModel by viewModels()

    private var courseAdapter: CourseAdapter = CourseAdapter()

    private lateinit var pagedCourseAdapter: PagedCourseAdapter

    private val tag = this.javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("In $tag", "onCreateView")
        binding = FragmentCourseListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("In $tag", "onViewCreated")

        setUpHeader()

        initView()

        initListeners()

        initObservers()

        fetchCourseList()

    }

    private fun fetchCourseList() {
        viewModel.getPagedCourseList()
    }

    private fun initObservers() {

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                Log.i("In $tag", "initObservers before collect pagedCourse")
//
                viewModel.productsFlow.collectLatest { pagedData ->
                    Log.i("In $tag", "initObservers pagedCourse $pagedData")
                    pagedCourseAdapter.submitData(pagedData)
                }
            }

        }

//        lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                Log.i("In $tag", "initObservers before collect pagedCourse")
//
//                viewModel.productsFlow.collectLatest { pagedData ->
//                    Log.i("In $tag", "initObservers pagedCourse $pagedData")
//                    pagedCourseAdapter.submitData(pagedData)
//                }
//                viewModel.courseResponse.collectLatest { response ->
//                    response?.let {
//                        Log.i("In $tag", "initObservers courseResponse $it")
//                        courseAdapter.setData(it)
//                    }
//                }
//            }
//
//        }

    }

    private fun initListeners() {

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.btnNewCourse?.setOnClickListener {
            findNavController().navigate(R.id.add_course_dest)
        }

        courseAdapter.setOnClickListener { course ->
            val action =
                CourseListFragmentDirections.actionFragmentCourseListToFragmentSubjectList(course)
            findNavController().navigate(action)
        }
    }

    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Course List"
    }

    private fun initView() {
        pagedCourseAdapter = PagedCourseAdapter()
        binding?.rvCourseList?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvCourseList?.adapter = pagedCourseAdapter
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