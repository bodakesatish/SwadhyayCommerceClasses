package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchDetailEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatchDetailEntityLocalMapper
@Inject constructor() : BaseMapper<BatchDetail, BatchDetailEntity>() {

    override fun map(entity: BatchDetailEntity): BatchDetail {
        return BatchDetail(
            batchId = entity.batchId,
            courseId = entity.courseId,
            courseName = entity.courseName,
            subjectId = entity.subjectId,
            subjectName = entity.subjectName,
            teacherId = entity.teacherId,
            teacherName = entity.teacherName,
            batchDescription = entity.batchDescription,
            batchFee = entity.batchFee,
            batchStartDate = entity.batchStartDate,
            batchEndDate = entity.batchEndDate,
            batchStartTime = entity.batchStartTime,
            batchEndTime = entity.batchEndTime,
            batchStudentMaxStrength = entity.batchStudentMaxStrength
        )
    }

    override fun reverse(model: BatchDetail):  BatchDetailEntity {
        return BatchDetailEntity(
            batchId = model.batchId,
            courseId = model.courseId,
            courseName = model.courseName,
            subjectId = model.subjectId,
            subjectName = model.subjectName,
            teacherId = model.teacherId,
            teacherName = model.teacherName,
            batchDescription = model.batchDescription,
            batchFee = model.batchFee,
            batchStartDate = model.batchStartDate,
            batchEndDate = model.batchEndDate,
            batchStartTime = model.batchStartTime,
            batchEndTime = model.batchEndTime,
            batchStudentMaxStrength = model.batchStudentMaxStrength
        )

    }
}