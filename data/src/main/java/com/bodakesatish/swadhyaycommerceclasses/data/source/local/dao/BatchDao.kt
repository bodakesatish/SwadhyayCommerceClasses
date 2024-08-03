package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchEntity

@Dao
interface BatchDao : BaseDao<BatchEntity> {

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME}")
    fun getAllBatches(): List<BatchEntity>

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME} WHERE ${BatchEntity.Columns.BATCH_ID} = :batchId")
    fun getBatchById(batchId: Int): BatchEntity?

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME} WHERE ${BatchEntity.Columns.COURSE_ID} = :courseId")
    fun getAllBatchesByCourse(courseId: Int): List<BatchEntity>

    @Insert
    fun addBatch(batch: BatchEntity)

}