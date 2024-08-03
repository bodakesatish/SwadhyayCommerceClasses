package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date
import javax.inject.Inject

data class StudentRequestModel @Inject constructor(
    val studentId: Int,
    val studentFirstName: String,
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
) : BaseRequest