package com.bodakesatish.swadhyaycommerceclasses.ui.batch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowBatchBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch

class BatchAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Batch> = emptyList()
    var onBatchSelected: ((Batch) -> Unit)? = null

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

    fun setData(data: List<Batch>) {
        itemList = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(onBatchSelected: ((Batch)) -> Unit) {
        this.onBatchSelected = onBatchSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class BatchViewHolder(val binding: ListRowBatchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Batch, position: Int) {

            binding.tvBatchName.text = "${data.batchName} $position"
            binding.root.setOnClickListener {
                onBatchSelected?.invoke(data)
            }
        }

    }
}