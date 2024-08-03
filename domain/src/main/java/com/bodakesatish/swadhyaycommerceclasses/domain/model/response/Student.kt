package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date

data class Student(
    val studentId: Int,
    val courseId: Int,
    val studentFirstName: String,
    val studentMiddleName: String,
    val studentLastName: String,
    val studentDoB: Date,
    val studentGender: String,
    val studentAddress: String,
    val studentPhoneNumber: String,
    val studentEmail: String,
    val studentParentName: String,
    val studentParentPhoneNumber: String,
    val studentAdmissionDate: Date,
    val studentIsActive: Boolean
) : BaseResponse