package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatchEntityLocalMapper
@Inject constructor() : BaseMapper<Batch, BatchEntity>() {

    override fun map(entity: BatchEntity): Batch {
        return Batch(
            batchId = entity.batchId,
            courseId = entity.courseId,
            subjectId = entity.subjectId,
            teacherId = entity.teacherId,
            batchTitle = entity.batchTitle,
//            batchDescription = entity.batchDescription,
            batchFee = entity.batchFee,
            batchStartDate = entity.batchStartDate,
            batchEndDate = entity.batchEndDate,
            batchStartTime = entity.batchStartTime,
            batchEndTime = entity.batchEndTime
//            batchStudentMaxStrength = entity.batchStudentMaxStrength
        )
    }

    override fun reverse(model: Batch):  BatchEntity {
        return BatchEntity(
            batchId = model.batchId,
            courseId = model.courseId,
            subjectId = model.subjectId,
            teacherId = model.teacherId,
            batchTitle = model.batchTitle,
//            batchDescription = model.batchDescription,
            batchFee = model.batchFee,
            batchStartDate = model.batchStartDate,
            batchEndDate = model.batchEndDate,
            batchStartTime = model.batchStartTime,
            batchEndTime = model.batchEndTime
//            batchStudentMaxStrength = model.batchStudentMaxStrength
        )
    }
}