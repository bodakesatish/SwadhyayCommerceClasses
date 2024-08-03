package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = CourseEntity.TABLE_NAME
)
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.COURSE_ID)
    val courseId: Int = 0,
    @ColumnInfo(name = Columns.COURSE_NAME)
    val courseName: String,
    @ColumnInfo(name = Columns.COURSE_DURATION)
    val courseDuration: String,
    @ColumnInfo(name = Columns.COURSE_FEE)
    val courseFee: Int,
    @ColumnInfo(name = Columns.COURSE_DESCRIPTION)
    val courseDescription: String,
    @ColumnInfo(name = Columns.COURSE_START_DATE)
    val courseStartDate: Date,
    @ColumnInfo(name = Columns.COURSE_END_DATE)
    val courseEndDate: Date
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "CourseEntity"

    }

    internal object Columns {

        internal const val COURSE_ID = "courseId"

        internal const val COURSE_NAME = "courseName"

        internal const val COURSE_DURATION = "courseDuration"

        internal const val COURSE_FEE = "courseFee"

        internal const val COURSE_DESCRIPTION = "courseDescription"

        internal const val COURSE_START_DATE = "courseStartDate"

        internal const val COURSE_END_DATE = "courseEndDate"

    }
}