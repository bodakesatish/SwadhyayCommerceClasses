package com.bodakesatish.swadhyaycommerceclasses.ui.course.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.swadhyaycommerceclasses.databinding.ListRowCourseBinding
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course

class PagedCourseAdapter() : PagingDataAdapter<Course, PagedCourseAdapter.CourseViewHolder>(Course_COMPARATOR) {

    var onCourseSelected: ((Course) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ListRowCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        course?.let { holder.bind(it, position) }
    }

    companion object {
        private val Course_COMPARATOR = object : DiffUtil.ItemCallback<Course>() {
            override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
                Log.i("PagedCourseAdapter", "areItemsTheSame")
                Log.i("PagedCourseAdapter", "areItemsTheSame oldItem.courseId->${oldItem.courseId} newItem.courseId->${newItem.courseId} areSame->${oldItem.courseId == newItem.courseId}")
                return oldItem.courseId == newItem.courseId
            }

            override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
                return oldItem == newItem
            }
        }
    }

    fun setOnClickListener(onCourseSelected: ((Course)) -> Unit) {
        this.onCourseSelected = onCourseSelected
    }

    inner class CourseViewHolder(val binding: ListRowCourseBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Course, position: Int) {

            binding.tvNumber.text = "${position+1}."
            binding.tvCourseName.text = "${data.courseName}"
            binding.root.setOnClickListener{
                onCourseSelected?.invoke(data)
            }
        }

    }
}