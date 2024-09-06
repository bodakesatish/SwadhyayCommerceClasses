package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = BatchTimeTableEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BatchEntity::class,
            parentColumns = [BatchEntity.Columns.BATCH_ID],
            childColumns = [BatchTimeTableEntity.Columns.BATCH_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CourseEntity::class,
            parentColumns = [CourseEntity.Columns.COURSE_ID],
            childColumns = [BatchTimeTableEntity.Columns.COURSE_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = [SubjectEntity.Columns.SUBJECT_ID],
            childColumns = [BatchTimeTableEntity.Columns.SUBJECT_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TeacherEntity::class,
            parentColumns = [TeacherEntity.Columns.TEACHER_ID],
            childColumns = [BatchTimeTableEntity.Columns.TEACHER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BatchTimeTableEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.BATCH_TIME_TABLE_ID)
    val batchTimeTableId: Int = 0,
    @ColumnInfo(name = Columns.BATCH_ID, index = true)
    val batchId: Int,
    @ColumnInfo(name = Columns.COURSE_ID, index = true)
    val courseId: Int,
    @ColumnInfo(name = Columns.SUBJECT_ID, index = true)
    val subjectId: Int,
    @ColumnInfo(name = Columns.TEACHER_ID, index = true)
    val teacherId: Int,
    @ColumnInfo(name = Columns.BATCH_DATE)
    val batchDate: Date,
    @ColumnInfo(name = Columns.BATCH_DAY)
    val batchDay: String,
    @ColumnInfo(name = Columns.BATCH_STATUS)
    val batchStatus: Boolean,
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "BatchTimeTableEntity"

    }

    internal object Columns {

        internal const val BATCH_TIME_TABLE_ID = "batchTimeTableId"

        internal const val BATCH_ID = "batchId"

        internal const val COURSE_ID = "courseId"

        internal const val SUBJECT_ID = "subjectId"

        internal const val TEACHER_ID = "teacherId"

        internal const val BATCH_DATE = "batchDate"

        internal const val BATCH_DAY = "batchDay"

        internal const val BATCH_STATUS = "batchStatus"

    }
}