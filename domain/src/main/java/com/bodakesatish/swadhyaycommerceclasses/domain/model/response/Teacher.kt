package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date

data class Teacher(
    val teacherId: Int = 0,
    val teacherFirstName: String = "",
    val teacherMiddleName: String = "",
    val teacherLastName: String = ""
//    val teacherDesignation: String,
//    val teacherQualification: String,
//    val teacherDoB: Date,
//    val teacherExperience: Int,
//    val teacherGender: String,
//    val teacherDateOfJoining: Date,
//    val teacherPhoneNumber: String,
//    val teacherEmail: String,
//    val teacherSalary: Int,
//    val teacherStatus: Boolean
) : BaseResponse
