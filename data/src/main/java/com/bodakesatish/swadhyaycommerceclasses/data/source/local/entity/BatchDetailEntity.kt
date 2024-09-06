package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

data class BatchDetailEntity(
    val batchId: Int,
    val courseId: Int,
    val courseName: String,
    val subjectId: Int,
    val subjectName: String,
    val teacherId: Int,
    val teacherName: String,
    val batchTitle: String,
    val batchFee: Int,
    val batchStartDate: Date,
    val batchEndDate: Date,
    val batchStartTime: Date,
    val batchEndTime: Date,
//    val batchStudentMaxStrength: Int
) : BaseEntity()