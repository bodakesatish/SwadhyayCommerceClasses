package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date

data class Exam(
    val examId: Int,
    val batchId: Int,
    val examName: String,
    val examDate: Date,
    val totalMarks: Int,
) : BaseResponse