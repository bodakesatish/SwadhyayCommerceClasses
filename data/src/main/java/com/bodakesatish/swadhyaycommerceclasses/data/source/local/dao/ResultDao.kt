package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.ResultEntity

@Dao
interface ResultDao : BaseDao<ResultEntity> {

    @Query("SELECT * FROM ${ResultEntity.TABLE_NAME}")
    fun getAllResults(): List<ResultEntity>

    @Query("SELECT * FROM ${ResultEntity.TABLE_NAME} WHERE ${ResultEntity.Columns.RESULT_ID} = :resultId")
    fun getResultById(resultId: Int): ResultEntity?

    @Query("SELECT * FROM ${ResultEntity.TABLE_NAME} WHERE ${ResultEntity.Columns.STUDENT_ID} = :studentId")
    fun getResultsByStudent(studentId: Int): List<ResultEntity>

    @Query("SELECT * FROM ${ResultEntity.TABLE_NAME} WHERE ${ResultEntity.Columns.EXAM_ID} = :examId")
    fun getResultsByExam(examId: Int): List<ResultEntity>

//    @Query("SELECT * FROM ${ResultEntity.TABLE_NAME} WHERE ${ResultEntity.Columns.BATCH_ID} = :batchId")
//    fun getResultsByBatch(batchId: Int): List<ResultEntity>

    @Insert
    fun insertResult(result: ResultEntity)

}