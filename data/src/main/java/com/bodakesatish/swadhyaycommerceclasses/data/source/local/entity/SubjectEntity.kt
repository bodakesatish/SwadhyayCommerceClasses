package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity


@Entity(
    tableName = SubjectEntity.TABLE_NAME
)
data class SubjectEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.SUBJECT_ID)
    val subjectId: Int = 0,
    @ColumnInfo(name = Columns.COURSE_ID)
    val courseId: Int,
    @ColumnInfo(name = Columns.SUBJECT_NAME)
    val subjectName: String,
    @ColumnInfo(name = Columns.SUBJECT_FEE)
    val subjectFee: Int,
) : BaseEntity() {

    internal companion object {
        const val TABLE_NAME = "SubjectEntity"
    }

    internal object Columns {
        internal const val SUBJECT_ID = "subjectId"
        internal const val COURSE_ID = "courseId"
        internal const val SUBJECT_NAME = "subjectName"
        internal const val SUBJECT_FEE = "subjectFee"
    }

}