package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = ExamEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BatchEntity::class,
            parentColumns = [BatchEntity.Columns.BATCH_ID],
            childColumns = [ExamEntity.Columns.BATCH_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ExamEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.EXAM_ID)
    val examId: Int = 0,
    @ColumnInfo(name = Columns.BATCH_ID, index = true)
    val batchId: Int,
    @ColumnInfo(name = Columns.EXAM_NAME)
    val examName: String,
    @ColumnInfo(name = Columns.EXAM_DATE)
    val examDate: Date,
    @ColumnInfo(name = Columns.TOTAL_MARKS)
    val totalMarks: Int,
    @ColumnInfo(name = Columns.PASSING_MARKS)
    val passingMarks: Int,
    @ColumnInfo(name = Columns.RESULT_DATE)
    val resultDate: Date
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "ExamEntity"

    }

    internal object Columns {

        internal const val EXAM_ID = "examId"

        internal const val BATCH_ID = "batchId"

        internal const val EXAM_NAME = "examName"

        internal const val EXAM_DATE = "examDate"

        internal const val TOTAL_MARKS = "totalMarks"

        internal const val PASSING_MARKS = "passingMarks"

        internal const val RESULT_DATE = "resultDate"

    }
}