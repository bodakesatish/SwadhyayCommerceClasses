package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.window.OnBackInvokedCallback
import androidx.activity.OnBackPressedCallback
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

//    lateinit var onBackPressedCallback: OnBackPressedCallback
//    lateinit var onBackInvokedCallback: OnBackInvokedCallback
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



        viewModel.getCourseList()

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

        binding?.btnNewCourse?.setOnClickListener {
            findNavController().navigate(R.id.add_course_dest)
        }

        courseAdapter.setOnClickListener { course ->
            val bundle = Bundle()
            bundle.putInt(Constants.COURSE_ID,course.courseId)
            findNavController().navigate(R.id.subject_list_dest, bundle)
        }

//        onBackPressedCallback = object : OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//                // Handle the back gesture here, e.g., navigate back
//                findNavController().popBackStack()
//            }
//        }
//
//        requireActivity().onBackPressedDispatcher.addCallback(
//            viewLifecycleOwner,
//            onBackPressedCallback
//        )
//
//        onBackInvokedCallback = OnBackInvokedCallback {
//            // Handle the back gesture here
//            findNavController().popBackStack()
//        }

    }

    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Course List"
    }

    private fun initView() {
        binding?.rvCourseList?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvCourseList?.adapter = courseAdapter
        binding?.rvCourseList?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

    }

    override fun onDestroyView() {
//        onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback)
//        onBackPressedCallback.remove()
        super.onDestroyView()
        binding = null
    }


}