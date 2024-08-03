package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherAttendanceEntity
import java.util.Date

@Dao
interface TeacherAttendanceDao : BaseDao<TeacherAttendanceEntity> {

    @Query("SELECT * FROM ${TeacherAttendanceEntity.TABLE_NAME} WHERE ${TeacherAttendanceEntity.Columns.TEACHER_ATTENDANCE_DATE} = :attendanceDate")
    fun getAllTeacherAttendanceByAttendanceDate(attendanceDate: Date): List<TeacherAttendanceEntity>

    @Query("SELECT * FROM ${TeacherAttendanceEntity.TABLE_NAME} WHERE ${TeacherAttendanceEntity.Columns.TEACHER_ID} = :teacherId")
    fun getTeacherAttendanceByTeacherId(teacherId: Int): List<TeacherAttendanceEntity>

    @Query("SELECT * FROM ${TeacherAttendanceEntity.TABLE_NAME} WHERE ${TeacherAttendanceEntity.Columns.TEACHER_ID} = :teacherId AND ${TeacherAttendanceEntity.Columns.TEACHER_ATTENDANCE_DATE} = :attendanceDate")
    fun getTeacherAttendanceByTeacherIdAndAttendanceDate(teacherId: Int, attendanceDate: Date): TeacherAttendanceEntity?

    @Insert
    fun insertTeacherAttendance(teacherAttendance: TeacherAttendanceEntity)

}