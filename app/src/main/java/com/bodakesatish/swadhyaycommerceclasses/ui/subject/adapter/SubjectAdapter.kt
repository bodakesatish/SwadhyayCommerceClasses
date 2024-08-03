package com.bodakesatish.swadhyaycommerceclasses.ui.subject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowSubjectBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject

class SubjectAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Subject> = emptyList()
    var onSubjectSelected: ((Subject) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListRowSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is SubjectViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<Subject>) {
        itemList = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(onSubjectSelected: ((Subject)) -> Unit) {
        this.onSubjectSelected = onSubjectSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class SubjectViewHolder(val binding: ListRowSubjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Subject, position: Int) {

            binding.tvSubjectName.text = "${data.subjectName} - ${data.subjectFee}"
            binding.root.setOnClickListener {
                onSubjectSelected?.invoke(data)
            }
        }
    }

}