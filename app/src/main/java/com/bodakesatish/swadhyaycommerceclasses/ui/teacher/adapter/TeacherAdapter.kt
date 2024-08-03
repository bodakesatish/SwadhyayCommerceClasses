package com.bodakesatish.swadhyaycommerceclasses.ui.teacher.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowTeacherBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher

class TeacherAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Teacher> = emptyList()
    var onTeacherSelected: ((Teacher) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ListRowTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is TeacherViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setData(data: List<Teacher>) {
        itemList = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(onTeacherSelected: ((Teacher)) -> Unit) {
        this.onTeacherSelected = onTeacherSelected
    }

    inner class TeacherViewHolder(val binding: ListRowTeacherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Teacher, position: Int) {

            binding.tvTeacherName.text = "${data.teacherFirstName} $position"
            binding.root.setOnClickListener {

            }
        }
    }
}