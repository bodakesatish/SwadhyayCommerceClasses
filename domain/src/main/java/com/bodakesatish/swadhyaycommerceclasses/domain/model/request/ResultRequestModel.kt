package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import java.util.Date
import javax.inject.Inject

data class ResultRequestModel @Inject constructor(
    val resultId: Int,
    val studentId: Int,
    val examId: Int,
    val marksObtained: Int,
    val resultDate: Date
) : BaseRequest
