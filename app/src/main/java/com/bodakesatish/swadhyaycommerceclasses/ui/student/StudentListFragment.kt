package com.bodakesatish.swadhyaycommerceclasses.ui.student

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
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentStudentListBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.course.CourseListFragmentDirections
import com.bodakesatish.swadhyaycommerceclasses.ui.student.adapter.StudentAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentListFragment : Fragment() {

    private var binding: FragmentStudentListBinding? = null
    private val viewModel: StudentListViewModel by viewModels()

    private var studentAdapter: StudentAdapter = StudentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHeader()
        initListeners()
        initView()

        viewModel.getStudentList()

        viewModel.studentResponse.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        studentAdapter.setData(it)
                    }
                }
                else -> {
                    studentAdapter.setData(emptyList())
                }
            }

        }

        binding?.btnNewStudent?.setOnClickListener{
            findNavController().navigate(R.id.add_student_dest)
        }

    }

    private fun initListeners() {
        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        studentAdapter.setOnClickListener {
            val action = StudentListFragmentDirections.actionFragmentStudentListToFragmentAddStudent(student = it)
            findNavController().navigate(action)        }
    }

    private fun initHeader() {
        binding?.headerGeneric?.tvHeader?.text = getString(R.string.student_list)
    }

    private fun initView() {
        binding?.rvStudentList?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvStudentList?.adapter = studentAdapter
        binding?.rvStudentList?.addItemDecoration(
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