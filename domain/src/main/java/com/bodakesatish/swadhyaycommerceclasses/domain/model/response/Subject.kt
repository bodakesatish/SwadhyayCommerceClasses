package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import javax.inject.Inject

data class Subject @Inject constructor(
    val subjectId: Int,
    val courseId: Int,
    val subjectName: String,
    val subjectFee: Int
) : BaseResponse
