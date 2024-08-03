package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity

@Entity(
    tableName = ResultEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StudentEntity::class,
            parentColumns = arrayOf(StudentEntity.Columns.STUDENT_ID),
            childColumns = arrayOf(ResultEntity.Columns.STUDENT_ID),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = ExamEntity::class,
            parentColumns = arrayOf(ExamEntity.Columns.EXAM_ID),
            childColumns = arrayOf(ResultEntity.Columns.EXAM_ID),
            onDelete = androidx.room.ForeignKey.CASCADE
        )
    ]
)
data class ResultEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.RESULT_ID)
    val resultId: Int = 0,
    @ColumnInfo(name = Columns.STUDENT_ID, index = true)
    val studentId: Int,
    @ColumnInfo(name = Columns.EXAM_ID, index = true)
    val examId: String,
    @ColumnInfo(name = Columns.MARKS_OBTAINED)
    val marksObtained: Int,
    @ColumnInfo(name = Columns.PASSING_STATUS)
    val passingStatus: String //passed, failed
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "ResultEntity"

    }

    internal object Columns {

        internal const val RESULT_ID = "resultId"

        internal const val STUDENT_ID = "studentId"

        internal const val EXAM_ID = "examId"

        internal const val MARKS_OBTAINED = "marksObtained"

        internal const val PASSING_STATUS = "passingStatus"

    }
}