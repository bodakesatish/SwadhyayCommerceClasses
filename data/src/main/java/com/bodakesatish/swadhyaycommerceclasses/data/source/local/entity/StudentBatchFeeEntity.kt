package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity
import java.util.Date

@Entity(
    tableName = StudentBatchFeeEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = StudentEntity::class,
            parentColumns = [StudentEntity.Columns.STUDENT_ID],
            childColumns = [StudentBatchFeeEntity.Columns.STUDENT_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BatchEntity::class,
            parentColumns = [BatchEntity.Columns.BATCH_ID],
            childColumns = [StudentBatchFeeEntity.Columns.BATCH_ID],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class StudentBatchFeeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Columns.STUDENT_FEE_ID)
    val studentFeeId: Int = 0,
    @ColumnInfo(name = Columns.STUDENT_ID)
    val studentId: Int,
    @ColumnInfo(name = Columns.BATCH_ID)
    val batchId: Int,
    @ColumnInfo(name = Columns.STUDENT_FEE_AMOUNT)
    val studentFeeAmount: Double,
    @ColumnInfo(name = Columns.STUDENT_FEE_PAYMENT_DATE)
    val studentFeePaymentDate: Date,
    @ColumnInfo(name = Columns.STUDENT_FEE_STATUS)
    val studentFeeStatus: String //paid, unpaid
) : BaseEntity() {

    internal companion object {

        const val TABLE_NAME = "StudentBatchFeeEntity"

    }

    internal object Columns {

        internal const val STUDENT_FEE_ID = "studentFeeId"

        internal const val STUDENT_ID = "studentId"

        internal const val BATCH_ID = "batchId"

        internal const val STUDENT_FEE_AMOUNT = "studentFeeAmount"

        internal const val STUDENT_FEE_PAYMENT_DATE = "studentFeePaymentDate"

        internal const val STUDENT_FEE_STATUS = "studentFeeStatus"

    }
}