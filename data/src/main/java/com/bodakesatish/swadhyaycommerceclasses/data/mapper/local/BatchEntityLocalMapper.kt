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
            batchName = entity.batchName,
            batchDescription = entity.batchDescription,
            batchFee = entity.batchFee,
            batchStartDate = entity.batchStartDate,
            batchEndDate = entity.batchEndDate,
            batchTimeDuration = entity.batchTimeDuration,
            batchStudentMaxStrength = entity.batchStudentMaxStrength
        )
    }

    override fun reverse(model: Batch):  BatchEntity {
        return BatchEntity(
            batchId = model.batchId,
            courseId = model.courseId,
            subjectId = model.subjectId,
            batchName = model.batchName,
            batchDescription = model.batchDescription,
            batchFee = model.batchFee,
            batchTimeDuration = model.batchTimeDuration,
            batchStartDate = model.batchStartDate,
            batchEndDate = model.batchEndDate,
            batchStudentMaxStrength = model.batchStudentMaxStrength
        )
    }
}