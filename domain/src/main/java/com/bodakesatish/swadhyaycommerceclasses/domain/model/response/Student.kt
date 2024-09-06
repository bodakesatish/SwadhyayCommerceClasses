package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.io.Serializable
import java.util.Date

data class Student(
    val studentId: Int = 0,
    var courseId: Int = 0,
    var studentFirstName: String = "",
    var studentMiddleName: String = "",
    var studentLastName: String = "",
//    val studentDoB: Date,
//    val studentGender: String,
//    val studentAddress: String,
//    val studentPhoneNumber: String,
//    val studentEmail: String,
//    val studentParentName: String,
//    val studentParentPhoneNumber: String,
//    val studentAdmissionDate: Date,
//    val studentIsActive: Boolean
) : BaseResponse, Serializable