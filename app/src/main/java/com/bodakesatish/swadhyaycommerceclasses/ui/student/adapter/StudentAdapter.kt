package com.bodakesatish.swadhyaycommerceclasses.ui.student.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowStudentBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student

class StudentAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Student> = emptyList()
    var onStudentSelected: ((Student) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListRowStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is StudentViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<Student>) {
        itemList = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(onStudentSelected: ((Student)) -> Unit) {
        this.onStudentSelected = onStudentSelected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class StudentViewHolder(val binding: ListRowStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Student, position: Int) {
            binding.tvStudentName.text = "${data.studentFirstName} $position"
        }

    }
}