package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchDetailEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchTimeTableEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.CourseEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.SubjectEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch

@Dao
interface BatchTimeTableDao : BaseDao<BatchTimeTableEntity> {

    @Insert
    fun insertBatchTimeTable(batchTimeTable: BatchTimeTableEntity)

    @Insert
    fun insertAllBatchTimeTable(batchTimeTableList: List<BatchTimeTableEntity>)

    @Query("SELECT * FROM ${BatchTimeTableEntity.TABLE_NAME} WHERE ${BatchTimeTableEntity.Columns.BATCH_ID} = :batchId")
    fun getBatchTimeTableById(batchId: Int) : List<BatchTimeTableEntity>


}