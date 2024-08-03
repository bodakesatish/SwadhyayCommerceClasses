package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentBatchFeeEntity

@Dao
interface StudentBatchFeeDao : BaseDao<StudentBatchFeeEntity> {

    @Query("SELECT * FROM ${StudentBatchFeeEntity.TABLE_NAME}")
    fun getAllStudentBatchFees(): List<StudentBatchFeeEntity>

    @Query("SELECT * FROM ${StudentBatchFeeEntity.TABLE_NAME} WHERE ${StudentBatchFeeEntity.Columns.STUDENT_ID} = :studentId")
    fun getStudentBatchFeeByStudentId(studentId: Int): List<StudentBatchFeeEntity>

    @Query("SELECT * FROM ${StudentBatchFeeEntity.TABLE_NAME} WHERE ${StudentBatchFeeEntity.Columns.BATCH_ID} = :batchId")
    fun getStudentBatchFeeByBatchId(batchId: Int): List<StudentBatchFeeEntity>

    @Insert
    fun insertStudentBatchFee(studentBatchFee: StudentBatchFeeEntity)

}