package com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.common.DateHelper
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowBatchBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail

class BatchAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<BatchDetail> = emptyList()
    var onBatchSelected: ((BatchDetail) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListRowBatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is BatchViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<BatchDetail>) {
        itemList = data
        notifyItemRangeChanged(0, data.size)
    }

    fun setOnClickListener(onBatchSelected: ((BatchDetail)) -> Unit) {
        this.onBatchSelected = onBatchSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class BatchViewHolder(val binding: ListRowBatchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: BatchDetail, position: Int) {

            binding.tvNumber.text = "${position + 1}."
            binding.tvBatchName.text = "${data.courseName} - ${data.subjectName}"
            binding.tvBatchTime.text = "${DateHelper.formatTime(data.batchStartTime)} - ${DateHelper.formatTime(data.batchEndTime)}"

            binding.root.setOnClickListener {
                onBatchSelected?.invoke(data)
            }
        }

    }
}