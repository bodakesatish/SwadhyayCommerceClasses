package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date

data class BatchTimeTable(
    val batchTimeTableId : Int = 0,
    val batchId: Int = 0,
    var courseId: Int = 0,
    var subjectId: Int = 0,
    var teacherId: Int = 0,
    var batchDate: Date = Date(),
    var batchDay: String = "",
    var batchStatus: Boolean = false
) : Serializable, BaseResponse
