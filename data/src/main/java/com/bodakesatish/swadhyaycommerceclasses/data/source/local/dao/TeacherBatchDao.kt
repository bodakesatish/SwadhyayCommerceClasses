package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherBatchEntity

@Dao
interface TeacherBatchDao : BaseDao<TeacherBatchEntity> {

    @Query("SELECT * FROM ${TeacherBatchEntity.TABLE_NAME}")
    fun getAllTeacherBatches(): List<TeacherBatchEntity>

    @Query("SELECT * FROM ${TeacherBatchEntity.TABLE_NAME} WHERE ${TeacherBatchEntity.Columns.TEACHER_ID} = :teacherId")
    fun getTeacherBatchesByTeacherId(teacherId: Int): List<TeacherBatchEntity>

}