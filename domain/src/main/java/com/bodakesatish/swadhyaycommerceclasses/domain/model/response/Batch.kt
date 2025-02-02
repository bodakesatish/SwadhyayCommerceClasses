package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date
import javax.inject.Inject

data class Batch(
    val batchId: Int = 0,
    var courseId: Int = 0,
    var subjectId: Int = 0,
    var teacherId: Int = 0,
    var batchTitle: String = "",
//    var batchDescription: String,
    val batchFee: Int = 0,
    var batchStartDate: Date = Date(),
    var batchEndDate: Date = Date(),
    var batchStartTime: Date = Date(),
    var batchEndTime: Date = Date()
//    val batchStudentMaxStrength: Int,
) : Serializable, BaseResponse
