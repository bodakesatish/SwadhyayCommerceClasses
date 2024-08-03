package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = TeacherAttendanceEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = TeacherEntity::class,
            parentColumns = [TeacherEntity.Columns.TEACHER_ID],
            childColumns = [TeacherAttendanceEntity.Columns.TEACHER_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TeacherAttendanceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.TEACHER_ATTENDANCE_ID)
    val teacherAttendanceId: Int = 0,
    @ColumnInfo(name = Columns.TEACHER_ID)
    val teacherId: Int,
    @ColumnInfo(name = Columns.TEACHER_ATTENDANCE_DATE)
    val teacherAttendanceDate: Date,
    @ColumnInfo(name = Columns.TEACHER_ATTENDANCE_STATUS)
    val teacherAttendanceStatus: String // Present, Absent
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "TeacherAttendanceEntity"

    }

    internal object Columns {

        internal const val TEACHER_ATTENDANCE_ID = "teacherAttendanceId"

        internal const val TEACHER_ID = "teacherId"

        internal const val TEACHER_ATTENDANCE_DATE = "teacherAttendanceDate"

        internal const val TEACHER_ATTENDANCE_STATUS = "teacherAttendanceStatus"

    }
}