package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.R
import com.bodakesatish.swadhyaycommerceclasses.common.Constants
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchTimeTableListBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter.BatchAdapter
import com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter.BatchTimingAdapter
import com.bodakesatish.swadhyaycommerceclasses.ui.student.AddStudentFragmentArgs
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BatchTimeTableFragment : Fragment() {

    private var binding: FragmentBatchTimeTableListBinding? = null
    private val viewModel: BatchTimeTableListViewModel by viewModels()

    private var batchAdapter: BatchTimingAdapter = BatchTimingAdapter()
    private lateinit var batchDetail: BatchDetail

    val args: BatchTimeTableFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBatchTimeTableListBinding.inflate(inflater, container, false)
        args.batchDetail?.let {
            batchDetail = it
        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHeader()

        initView()

        initListeners()

        initObservers()

        initData()

        fetchBatchTimeTable()

    }

    private fun fetchBatchTimeTable() {
        viewModel.getBatchTimeTableList(batchDetail.batchId)
    }

    private fun initHeader() {
        binding?.headerGeneric?.tvHeader?.text = "List of Batches"
    }

    private fun initData() {
       // viewModel.getBatchTimeTableList()
    }

    private fun initObservers() {
        viewModel.batchResponse.observe(viewLifecycleOwner) { response ->

            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        batchAdapter.setData(it)
                    }
                }

                else -> {
                    batchAdapter.setData(emptyList())
                }
            }
        }
    }

    private fun initListeners() {
        binding?.btnNewBatch?.setOnClickListener {
            viewModel.createBatchTimeTableList(batchDetail.batchId)
        }

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initView() {
        binding?.rvBatchList?.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding?.rvBatchList?.adapter = batchAdapter
        binding?.rvBatchList?.addItemDecoration(
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