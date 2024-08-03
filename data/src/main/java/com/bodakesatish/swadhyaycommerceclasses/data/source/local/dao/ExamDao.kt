package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.ExamEntity

@Dao
interface ExamDao : BaseDao<ExamEntity> {

    @Query("SELECT * FROM ${ExamEntity.TABLE_NAME}")
    fun getAllExams(): List<ExamEntity>

    @Query("SELECT * FROM ${ExamEntity.TABLE_NAME} WHERE ${ExamEntity.Columns.EXAM_ID} = :examId")
    fun getExamById(examId: Int): ExamEntity?

    @Insert
    fun insertExam(exam: ExamEntity)

}