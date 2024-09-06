package com.bodakesatish.swadhyaycommerceclasses.ui.teacher

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
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentTeacherListBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.teacher.adapter.TeacherAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherListFragment : Fragment() {

    private var binding: FragmentTeacherListBinding? = null
    private val viewModel: TeacherListViewModel by viewModels()

    private var teacherAdapter: TeacherAdapter = TeacherAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeacherListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpHeader()

        initView()

        initListeners()

        initObservers()

        fetchTeacherList()

    }

    private fun fetchTeacherList() {
        viewModel.getTeacherList()
    }


    private fun setUpHeader() {
        binding?.headerGeneric?.tvHeader?.text = "Teacher List"
    }

    private fun initView() {
        binding?.rvTeacherList?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvTeacherList?.adapter = teacherAdapter
        binding?.rvTeacherList?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initListeners() {

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }

        binding?.btnNewTeacher?.setOnClickListener {
            findNavController().navigate(R.id.add_teacher_dest)
        }

    }

    private fun initObservers() {
        viewModel.teacherResponse.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        teacherAdapter.setData(it)
                    }
                }

                else -> {
                    teacherAdapter.setData(emptyList())
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}