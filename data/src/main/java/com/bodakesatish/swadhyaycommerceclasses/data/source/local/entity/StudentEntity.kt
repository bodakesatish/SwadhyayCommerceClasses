package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = StudentEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = [CourseEntity.Columns.COURSE_ID],
            childColumns = [StudentEntity.Columns.COURSE_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class StudentEntity(
    @ColumnInfo(name = Columns.STUDENT_ID)
    @PrimaryKey(autoGenerate = true)
    val studentId: Int = 0,
    @ColumnInfo(name = Columns.COURSE_ID)
    val courseId: Int,
    @ColumnInfo(name = Columns.STUDENT_FIRST_NAME)
    val studentFirstName: String,
    @ColumnInfo(name = Columns.STUDENT_MIDDLE_NAME)
    val studentMiddleName: String,
    @ColumnInfo(name = Columns.STUDENT_LAST_NAME)
    val studentLastName: String,
    @ColumnInfo(name = Columns.STUDENT_DOB)
    val studentDoB: Date,
    @ColumnInfo(name = Columns.STUDENT_GENDER)
    val studentGender: String,
    @ColumnInfo(name = Columns.STUDENT_ADDRESS)
    val studentAddress: String,
    @ColumnInfo(name = Columns.STUDENT_PHONE_NUMBER)
    val studentPhoneNumber: String,
    @ColumnInfo(name = Columns.STUDENT_EMAIL)
    val studentEmail: String,
    @ColumnInfo(name = Columns.STUDENT_PARENT_NAME)
    val studentParentName: String,
    @ColumnInfo(name = Columns.STUDENT_PARENT_PHONE_NUMBER)
    val studentParentPhoneNumber: String,
    @ColumnInfo(name = Columns.STUDENT_ADMISSION_DATE)
    val studentAdmissionDate: Date, // Consider using Date or Long for date storage
    @ColumnInfo(name = Columns.STUDENT_IS_ACTIVE)
    val studentIsActive: Boolean //true, false
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "StudentEntity"

    }

    internal object Columns {

        internal const val STUDENT_ID = "student_id"

        internal const val COURSE_ID = "course_id"

        internal const val STUDENT_FIRST_NAME = "student_first_name"

        internal const val STUDENT_MIDDLE_NAME = "student_middle_name"

        internal const val STUDENT_LAST_NAME = "student_last_name"

        internal const val STUDENT_DOB = "student_dob"

        internal const val STUDENT_GENDER = "student_gender"

        internal const val STUDENT_ADDRESS = "student_address"

        internal const val STUDENT_PHONE_NUMBER = "student_phone_number"

        internal const val STUDENT_EMAIL = "student_email"

        internal const val STUDENT_PARENT_NAME = "student_parent_name"

        internal const val STUDENT_PARENT_PHONE_NUMBER = "student_parent_phone_number"

        internal const val STUDENT_ADMISSION_DATE = "student_admission_date"

        internal const val STUDENT_IS_ACTIVE = "student_active"

    }

}