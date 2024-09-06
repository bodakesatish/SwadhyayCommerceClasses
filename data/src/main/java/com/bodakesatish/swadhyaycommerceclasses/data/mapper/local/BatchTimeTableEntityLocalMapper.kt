package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchTimeTableEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchTimeTable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatchTimeTableEntityLocalMapper
@Inject constructor() : BaseMapper<BatchTimeTable, BatchTimeTableEntity>() {

    override fun map(entity: BatchTimeTableEntity): BatchTimeTable {
        return BatchTimeTable(
            batchTimeTableId = entity.batchTimeTableId,
            batchId = entity.batchId,
            courseId = entity.courseId,
            subjectId = entity.subjectId,
            teacherId = entity.teacherId,
            batchDate = entity.batchDate,
            batchDay = entity.batchDay,
            batchStatus = entity.batchStatus
        )
    }

    override fun reverse(model: BatchTimeTable):  BatchTimeTableEntity {
        return BatchTimeTableEntity(
            batchTimeTableId = model.batchTimeTableId,
            batchId = model.batchId,
            courseId = model.courseId,
            subjectId = model.subjectId,
            teacherId = model.teacherId,
            batchDate = model.batchDate,
            batchDay = model.batchDay,
            batchStatus = model.batchStatus
        )
    }
}