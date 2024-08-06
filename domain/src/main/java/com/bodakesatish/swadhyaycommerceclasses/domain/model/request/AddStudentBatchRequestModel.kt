package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest

data class AddStudentBatchRequestModel(
    val courseId: Int,
    val subjectId: Int
) : BaseRequest
