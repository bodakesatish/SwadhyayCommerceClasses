package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = BatchEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = [CourseEntity.Columns.COURSE_ID],
            childColumns = [BatchEntity.Columns.COURSE_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = [SubjectEntity.Columns.SUBJECT_ID],
            childColumns = [BatchEntity.Columns.SUBJECT_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TeacherEntity::class,
            parentColumns = [TeacherEntity.Columns.TEACHER_ID],
            childColumns = [BatchEntity.Columns.TEACHER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BatchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.BATCH_ID)
    val batchId: Int = 0,
    @ColumnInfo(name = Columns.COURSE_ID, index = true)
    val courseId: Int,
    @ColumnInfo(name = Columns.SUBJECT_ID, index = true)
    val subjectId: Int,
    @ColumnInfo(name = Columns.TEACHER_ID, index = true)
    val teacherId: Int,
    @ColumnInfo(name = Columns.BATCH_NAME)
    val batchName: String,
    @ColumnInfo(name = Columns.BATCH_DESCRIPTION)
    val batchDescription: String,
    @ColumnInfo(name = Columns.BATCH_FEE)
    val batchFee: Int,
    @ColumnInfo(name = Columns.BATCH_START_DATE)
    val batchStartDate: Date,
    @ColumnInfo(name = Columns.BATCH_END_DATE)
    val batchEndDate: Date,
    @ColumnInfo(name = Columns.BATCH_START_TIME)
    val batchStartTime: Date,
    @ColumnInfo(name = Columns.BATCH_END_TIME)
    val batchEndTime: Date,
    @ColumnInfo(name = Columns.BATCH_STUDENT_MAX_STRENGTH)
    val batchStudentMaxStrength: Int,
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "BatchEntity"

    }

    internal object Columns {

        internal const val BATCH_ID = "batchId"

        internal const val COURSE_ID = "courseId"

        internal const val SUBJECT_ID = "subjectId"

        internal const val TEACHER_ID = "teacherId"

        internal const val BATCH_NAME = "batchName"

        internal const val BATCH_DESCRIPTION = "batchDescription"

        internal const val BATCH_FEE = "batchFee"

        internal const val BATCH_TIME_DURATION = "batchTimeDuration"

        internal const val BATCH_START_DATE = "batchStartDate"

        internal const val BATCH_END_DATE = "batchEndDate"

        internal const val BATCH_START_TIME = "batchStartTime"

        internal const val BATCH_END_TIME = "batchEndTime"

        internal const val BATCH_STUDENT_MAX_STRENGTH = "batchStudentMaxStrength"

    }
}