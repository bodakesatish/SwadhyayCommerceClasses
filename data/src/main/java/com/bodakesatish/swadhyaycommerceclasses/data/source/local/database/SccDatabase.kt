package com.bodakesatish.swadhyaycommerceclasses.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.convertors.BooleanConverter
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.convertors.DateConverter
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.BatchDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.BatchTimeTableDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.CourseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.ExamDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.LoginDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.ResultDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.StudentAttendanceDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.StudentBatchFeeDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.StudentDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.SubjectDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.TeacherAttendanceDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.TeacherBatchDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.TeacherDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchTimeTableEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.CourseEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.ExamEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.LoginEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.ResultEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentAttendanceEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentBatchFeeEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.SubjectEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherAttendanceEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherBatchEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student

@Database(
    entities = [
        LoginEntity::class,
        CourseEntity::class,
        BatchEntity::class,
        ExamEntity::class,
        ResultEntity::class,
        StudentAttendanceEntity::class,
        StudentBatchFeeEntity::class,
        StudentEntity::class,
        TeacherAttendanceEntity::class,
        TeacherBatchEntity::class,
        TeacherEntity::class,
        SubjectEntity::class,
        BatchTimeTableEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class, BooleanConverter::class)
abstract class SccDatabase : RoomDatabase() {
    abstract fun loginDao(): LoginDao
    abstract fun courseDao(): CourseDao
    abstract fun batchDao(): BatchDao
    abstract fun examDao(): ExamDao
    abstract fun resultDao(): ResultDao
    abstract fun studentAttendanceDao(): StudentAttendanceDao
    abstract fun studentBatchFeeDao(): StudentBatchFeeDao
    abstract fun studentDao(): StudentDao
    abstract fun teacherAttendanceDao(): TeacherAttendanceDao
    abstract fun teacherBatchDao(): TeacherBatchDao
    abstract fun teacherDao(): TeacherDao
    abstract fun subjectDao(): SubjectDao
    abstract fun batchTimeTableDao(): BatchTimeTableDao
}