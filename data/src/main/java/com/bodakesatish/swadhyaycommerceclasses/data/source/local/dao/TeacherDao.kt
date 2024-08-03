package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherEntity

@Dao
interface TeacherDao : BaseDao<TeacherEntity> {

    @Query("SELECT * FROM ${TeacherEntity.TABLE_NAME}")
    fun getAllTeachers(): List<TeacherEntity>

    @Query("SELECT * FROM ${TeacherEntity.TABLE_NAME} WHERE ${TeacherEntity.Columns.TEACHER_ID} = :teacherId")
    fun getTeacherById(teacherId: Int): TeacherEntity?

    @Query("SELECT * FROM ${TeacherEntity.TABLE_NAME} WHERE ${TeacherEntity.Columns.TEACHER_FIRST_NAME} = :teacherFirstName")
    fun getTeacherByName(teacherFirstName: String): TeacherEntity?

    @Insert
    fun addTeacher(teacher: TeacherEntity): Long
}