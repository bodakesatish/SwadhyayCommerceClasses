package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date

data class Result(
    val resultId: Int,
    val studentId: Int,
    val examId: Int,
    val marksObtained: Int,
    val resultDate: Date
) : BaseResponse
