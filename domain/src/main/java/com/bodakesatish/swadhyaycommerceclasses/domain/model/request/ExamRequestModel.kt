package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date
import javax.inject.Inject

data class ExamRequestModel @Inject constructor(
    val examId: Int,
    val batchId: Int,
    val examName: String,
    val examDate: Date,
    val totalMarks: Int,
): BaseResponse