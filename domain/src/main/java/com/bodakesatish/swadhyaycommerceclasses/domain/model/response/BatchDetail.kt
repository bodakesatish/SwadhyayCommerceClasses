package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date

data class BatchDetail(
    val batchId: Int,
    val courseId: Int,
    val courseName: String,
    val subjectId: Int,
    val subjectName: String,
    val teacherId: Int,
    val teacherName: String,
    val batchDescription: String,
    val batchFee: Int,
    val batchStartDate: Date,
    val batchEndDate: Date,
    val batchStartTime: Date,
    val batchEndTime: Date,
    val batchStudentMaxStrength: Int
): Serializable, BaseResponse