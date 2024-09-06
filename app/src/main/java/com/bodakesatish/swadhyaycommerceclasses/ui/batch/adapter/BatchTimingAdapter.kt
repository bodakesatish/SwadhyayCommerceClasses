package com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowBatchTimingBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchTimeTable

class BatchTimingAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<BatchTimeTable> = emptyList()
    var onBatchSelected: ((BatchTimeTable) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListRowBatchTimingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is BatchViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<BatchTimeTable>) {
        itemList = data
        notifyItemRangeChanged(0, data.size)
    }

    fun setOnClickListener(onBatchSelected: ((BatchTimeTable)) -> Unit) {
        this.onBatchSelected = onBatchSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class BatchViewHolder(val binding: ListRowBatchTimingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: BatchTimeTable, position: Int) {

            binding.tvNumber.text = "${position + 1}."
            binding.tvBatchName.text = "${data.batchDate} - ${data.batchDay}"

            binding.root.setOnClickListener {
                onBatchSelected?.invoke(data)
            }
        }

    }
}