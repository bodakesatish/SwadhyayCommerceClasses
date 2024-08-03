package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity

@Entity(tableName = TeacherBatchEntity.TABLE_NAME)
data class TeacherBatchEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.TEACHER_BATCH_ID)
    val teacherBatchId: Int = 0,
    @ColumnInfo(name = Columns.TEACHER_ID)
    val teacherId: Int,
    @ColumnInfo(name = Columns.BATCH_ID)
    val batchId: Int
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "table_teacher_batch"

    }

    object Columns {

        internal const val TEACHER_BATCH_ID = "teacherBatchId"

        internal const val TEACHER_ID = "teacherId"

        internal const val BATCH_ID = "batchId"

    }

}
