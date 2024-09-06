package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(tableName = TeacherEntity.TABLE_NAME)
data class TeacherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.TEACHER_ID)
    val teacherId: Int = 0,
    @ColumnInfo(name = Columns.TEACHER_FIRST_NAME)
    val teacherFirstName: String,
    @ColumnInfo(name = Columns.TEACHER_MIDDLE_NAME)
    val teacherMiddleName: String,
    @ColumnInfo(name = Columns.TEACHER_LAST_NAME)
    val teacherLastName: String
//    @ColumnInfo(name = Columns.TEACHER_DESIGNATION)
//    val teacherDesignation: String,
//    @ColumnInfo(name = Columns.TEACHER_QUALIFICATION)
//    val teacherQualification: String,
//    @ColumnInfo(name = Columns.TEACHER_DO_B)
//    val teacherDoB: Date,
//    @ColumnInfo(name = Columns.TEACHER_EXPERIENCE)
//    val teacherExperience: Int,
//    @ColumnInfo(name = Columns.TEACHER_GENDER)
//    val teacherGender: String,
//    @ColumnInfo(name = Columns.TEACHER_DATE_OF_JOINING)
//    val teacherDateOfJoining: Date,// Consider using Date or Long for date storage
//    @ColumnInfo(name = Columns.TEACHER_PHONE_NUMBER)
//    val teacherPhoneNumber: String,
//    @ColumnInfo(name = Columns.TEACHER_EMAIL)
//    val teacherEmail: String,
//    @ColumnInfo(name = Columns.TEACHER_SALARY)
//    val teacherSalary: Int,
//    @ColumnInfo(name = Columns.TEACHER_STATUS)
//    val teacherStatus: Boolean
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "table_teacher"

    }

    internal object Columns {

        internal const val TEACHER_ID = "teacherId"

        internal const val TEACHER_FIRST_NAME = "teacherFirstName"

        internal const val TEACHER_MIDDLE_NAME = "teacherMiddleName"

        internal const val TEACHER_LAST_NAME = "teacherLastName"

        internal const val TEACHER_DESIGNATION = "teacherDesignation"

        internal const val TEACHER_QUALIFICATION = "teacherQualification"

        internal const val TEACHER_DO_B = "teacherDoB"

        internal const val TEACHER_EXPERIENCE = "teacherExperience"

        internal const val TEACHER_GENDER = "teacherGender"

        internal const val TEACHER_DATE_OF_JOINING = "teacherDateOfJoining"

        internal const val TEACHER_PHONE_NUMBER = "teacherPhoneNumber"

        internal const val TEACHER_EMAIL = "teacherEmail"

        internal const val TEACHER_SALARY = "teacherSalary"

        internal const val TEACHER_STATUS = "teacherStatus"

    }
}