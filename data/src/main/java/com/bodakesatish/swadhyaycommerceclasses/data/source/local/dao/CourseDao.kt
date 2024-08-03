package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.CourseEntity

@Dao
interface CourseDao : BaseDao<CourseEntity> {

    // Add custom queries or methods here if needed
    @Query("SELECT * FROM ${CourseEntity.TABLE_NAME}")
    fun getAllCourses(): List<CourseEntity>

    @Query("SELECT * FROM ${CourseEntity.TABLE_NAME} WHERE ${CourseEntity.Columns.COURSE_ID} = :courseId")
    fun getCourseById(courseId: Int): CourseEntity?

    @Query("SELECT * FROM ${CourseEntity.TABLE_NAME} WHERE ${CourseEntity.Columns.COURSE_NAME} = :courseName")
    fun getCourseByName(courseName: String): CourseEntity?

    @Insert
    fun addCourse(course: CourseEntity) : Long

}