package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date
import javax.inject.Inject

data class CourseRequestModel @Inject constructor(
    val courseId: Int,
    val courseName: String,
    val courseDuration: String,
    val courseFee: Int,
    val courseDescription: String,
    val courseStartDate: Date,
    val courseEndDate: Date
) : BaseRequest