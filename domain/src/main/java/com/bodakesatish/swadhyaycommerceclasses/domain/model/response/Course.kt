package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date
import javax.inject.Inject

data class Course (
    var courseId: Int= 0,
    val courseName: String = "",
//    val courseDuration: String,
//    val courseFee: Int,
//    val courseDescription: String,
//    var courseStartDate: Date,
//    var courseEndDate: Date
) : Serializable, BaseResponse