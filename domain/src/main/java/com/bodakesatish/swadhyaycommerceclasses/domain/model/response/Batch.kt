package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date
import javax.inject.Inject

data class Batch @Inject constructor(
    val batchId: Int,
    var courseId: Int,
    var subjectId: Int,
    var teacherId: Int,
    val batchName: String,
    var batchDescription: String,
    val batchFee: Int,
    var batchStartDate: Date,
    var batchEndDate: Date,
    var batchStartTime: Date,
    var batchEndTime: Date,
    val batchStudentMaxStrength: Int,
) : Serializable, BaseResponse
