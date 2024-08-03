package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = StudentAttendanceEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StudentEntity::class,
            parentColumns = [StudentEntity.Columns.STUDENT_ID],
            childColumns = [StudentAttendanceEntity.Columns.STUDENT_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BatchEntity::class,
            parentColumns = [BatchEntity.Columns.BATCH_ID],
            childColumns = [StudentAttendanceEntity.Columns.BATCH_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class StudentAttendanceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.STUDENT_ATTENDANCE_ID)
    val studentAttendanceId: Int = 0,
    @ColumnInfo(name = Columns.STUDENT_ID, index = true)
    val studentId: Int,
    @ColumnInfo(name = Columns.BATCH_ID, index = true)
    val batchId: Int,
    @ColumnInfo(name = Columns.STUDENT_ATTENDANCE_DATE)
    val studentAttendanceDate: Date,
    @ColumnInfo(name = Columns.STUDENT_ATTENDANCE_STATUS)
    val studentAttendanceStatus: String // Present, Absent
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "StudentAttendanceEntity"

    }

    internal object Columns {

        internal const val STUDENT_ATTENDANCE_ID = "studentAttendanceId"

        internal const val STUDENT_ID = "studentId"

        internal const val BATCH_ID = "batchId"

        internal const val STUDENT_ATTENDANCE_DATE = "studentAttendanceDate"

        internal const val STUDENT_ATTENDANCE_STATUS = "studentAttendanceStatus"

    }
}