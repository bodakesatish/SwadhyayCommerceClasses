package com.bodakesatish.swadhyaycommerceclasses.ui.course.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowCourseBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course

class CourseAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Course> = emptyList()
    var onCourseSelected: ((Course) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListRowCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {

            is CourseViewHolder -> {
                holder.bind(itemList[position], position)
            }

        }
    }

    fun setData(data: List<Course>) {
        itemList = data
        notifyDataSetChanged()
    }

    fun setOnClickListener(onCourseSelected: ((Course)) -> Unit) {
        this.onCourseSelected = onCourseSelected
    }

    inner class CourseViewHolder(val binding: ListRowCourseBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Course, position: Int) {

            binding.tvCourseName.text = "${data.courseName} $position"
            binding.root.setOnClickListener{
                onCourseSelected?.invoke(data)
            }
        }

    }
}