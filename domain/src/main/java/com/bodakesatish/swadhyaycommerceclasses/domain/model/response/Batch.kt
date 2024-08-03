package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date

data class Batch(
    val batchId: Int,
    val courseId: Int,
    val subjectId: Int,
    val batchName: String,
    val batchDescription: String,
    val batchFee: Int,
    val batchTimeDuration: Int,
    val batchStartDate: Date,
    val batchEndDate: Date,
    val batchStudentMaxStrength: Int,
) : BaseResponse
