package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentAttendanceEntity
import java.util.Date

@Dao
interface StudentAttendanceDao : BaseDao<StudentAttendanceEntity> {

    @Query("SELECT * FROM ${StudentAttendanceEntity.TABLE_NAME}")
    fun getAllStudentAttendance(): List<StudentAttendanceEntity>

    @Query("SELECT * FROM ${StudentAttendanceEntity.TABLE_NAME} WHERE ${StudentAttendanceEntity.Columns.STUDENT_ID} = :studentId AND ${StudentAttendanceEntity.Columns.BATCH_ID} = :batchId AND ${StudentAttendanceEntity.Columns.STUDENT_ATTENDANCE_DATE} = :attendanceDate")
    fun getStudentAttendanceByStudentIdAndBatchIdAndAttendanceId(studentId: Int, batchId: Int, attendanceDate: Date): StudentAttendanceEntity?

    @Query("SELECT * FROM ${StudentAttendanceEntity.TABLE_NAME} WHERE ${StudentAttendanceEntity.Columns.STUDENT_ATTENDANCE_DATE} = :attendanceDate AND ${StudentAttendanceEntity.Columns.BATCH_ID} = :batchId")
    fun getStudentAttendanceByAttendanceDateAndBatchId(attendanceDate: Date, batchId: Int): List<StudentAttendanceEntity>

    @Insert
    fun insertStudentAttendance(studentAttendance: StudentAttendanceEntity)

}