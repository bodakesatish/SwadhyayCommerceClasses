package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date
import javax.inject.Inject

data class TeacherRequestModel @Inject constructor(
    val teacherId: Int,
    val teacherFirstName: String,
    val teacherLastName: String,
    val teacherDesignation: String,
    val teacherQualification: String,
    val teacherDoB: Date,
    val teacherExperience: Int,
    val teacherGender: String,
    val teacherDateOfJoining: Date,
    val teacherPhoneNumber: String,
    val teacherEmail: String,
    val teacherSalary: Double,
    val teacherStatus: String
) : BaseRequest
