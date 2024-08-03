package com.bodakesatish.swadhyaycommerceclasses.ui.subject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.DialogAddSubjectBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentSubjectBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.ui.subject.adapter.SubjectAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubjectFragment : Fragment() {

    private var binding: FragmentSubjectBinding? = null
    private val viewModel: SubjectViewModel by viewModels()

    private var subjectAdapter: SubjectAdapter = SubjectAdapter()
    private var courseId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        saveInstanceState: Bundle?
    ) : View ? {
        binding = FragmentSubjectBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseId = arguments?.getInt(Constants.COURSE_ID, 0) ?: 0

        viewModel.setCourseId(courseId)
        initView()

        viewModel.getSubjectList(courseId)

        viewModel.subjectResponse.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        subjectAdapter.setData(it)
                    }
                }
                else -> {
                    subjectAdapter.setData(emptyList())
                }
            }
        }

        binding?.btnAddSubject?.setOnClickListener {
            showAddSubjectDialog()
        }

    }

    private fun showAddSubjectDialog() {
        val builder = MaterialAlertDialogBuilder(requireContext())
        val dialogBinding = DialogAddSubjectBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)
        builder.setTitle("Add Subject Details")
            .setPositiveButton("Add", null)
            .setNegativeButton("Cancel", null)
        val dialog = builder.create()
        dialog.setCancelable(false)
        dialog.show()

        dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            val subjectName = dialogBinding.tvSubjectName.editText?.text.toString()
            val subjectFee = dialogBinding.tvSubjectFee.editText?.text.toString()
            if(subjectName.trim().isNotEmpty() && subjectFee.trim().isNotEmpty()) {
                viewModel.addSubject(Subject(0, courseId, subjectName, subjectFee.toInt()))
            } else {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun initView() {
        binding?.rvSubjectList?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvSubjectList?.adapter = subjectAdapter
        binding?.rvSubjectList?.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}