package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentEntity

@Dao
interface StudentDao : BaseDao<StudentEntity> {

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME}")
    fun getAllStudents(): List<StudentEntity>

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.Columns.STUDENT_ID} = :studentId")
    fun getStudentById(studentId: Int): StudentEntity?

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.Columns.STUDENT_FIRST_NAME} = :studentName")
    fun getStudentByName(studentName: String): StudentEntity?

    @Query("SELECT * FROM ${StudentEntity.TABLE_NAME} WHERE ${StudentEntity.Columns.COURSE_ID} = :courseId")
    fun getStudentsByCourse(courseId: Int): List<StudentEntity>

    @Insert
    fun addStudent(student: StudentEntity)

}