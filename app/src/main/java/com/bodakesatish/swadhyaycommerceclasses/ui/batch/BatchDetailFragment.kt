package com.bodakesatish.swadhyaycommerceclasses.ui.batch

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
import com.bodakesatish.swadhyaycommerceclasses.databinding.FragmentBatchListBinding
import com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter.BatchAdapter
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BatchDetailFragment : Fragment() {

    private var binding: FragmentBatchListBinding? = null
    private val viewModel: BatchListViewModel by viewModels()

    private var batchAdapter: BatchAdapter = BatchAdapter()
    private var courseId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBatchListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        courseId = arguments?.getInt(Constants.COURSE_ID, 0) ?: 0

        initHeader()

        initView()

        initListeners()

        initObservers()

        initData()

    }

    private fun initHeader() {
        binding?.headerGeneric?.tvHeader?.text = "List of Batches"
    }

    private fun initData() {
        viewModel.getBatchList()
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
            findNavController().navigate(R.id.add_batch_dest)
        }

        binding?.headerGeneric?.btnBack?.setOnClickListener {
            findNavController().popBackStack()
        }
        batchAdapter.setOnClickListener {
            val action = BatchListFragmentDirections.actionFragmentBatchListToFragmentBatchTiming(batchDetail = it)
            findNavController().navigate(action)
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