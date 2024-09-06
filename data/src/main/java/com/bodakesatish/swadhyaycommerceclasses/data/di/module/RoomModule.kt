package com.bodakesatish.swadhyaycommerceclasses.data.di.module

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
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
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.database.SccDatabase
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.LoginEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    val DATABASE_NAME = "scc.db"

    @Singleton
    @Provides
    fun providesDatabase(appContext: Application): SccDatabase {
        return Room.databaseBuilder(
            appContext,
            SccDatabase::class.java,
            DATABASE_NAME
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)

                    db.execSQL(
                        "INSERT INTO ${
                            LoginEntity.TABLE_NAME
                        } (${LoginEntity.Columns.USER_ID}, ${LoginEntity.Columns.NAME}, ${LoginEntity.Columns.EMAIL}, ${LoginEntity.Columns.PASSWORD}, ${LoginEntity.Columns.USER_TYPE}, ${LoginEntity.Columns.USER_NAME}, ${LoginEntity.Columns.USER_IMAGE}, ${LoginEntity.Columns.IS_ACTIVE}) VALUES " +
                                "(1, 'Satish Bodake', 'a@a.com', 'aaa', 'admin', 'a@a.com', 'none', true) "
                    )
                }
            }

            ).build()
    }

    @Singleton
    @Provides
    fun providesLoginDao(database: SccDatabase): LoginDao {
        return database.loginDao()
    }

    @Singleton
    @Provides
    fun providesCourseDao(database: SccDatabase): CourseDao {
        return database.courseDao()
    }

    @Singleton
    @Provides
    fun providesBatchDao(database: SccDatabase): BatchDao {
        return database.batchDao()
    }

    @Singleton
    @Provides
    fun providesExamDao(database: SccDatabase): ExamDao {
        return database.examDao()
    }

    @Singleton
    @Provides
    fun providesResultDao(database: SccDatabase): ResultDao {
        return database.resultDao()
    }

    @Singleton
    @Provides
    fun providesStudentAttendanceDao(database: SccDatabase): StudentAttendanceDao {
        return database.studentAttendanceDao()
    }

    @Singleton
    @Provides
    fun providesStudentBatchFeeDao(database: SccDatabase): StudentBatchFeeDao {
        return database.studentBatchFeeDao()
    }

    @Singleton
    @Provides
    fun providesStudentDao(database: SccDatabase): StudentDao {
        return database.studentDao()
    }

    @Singleton
    @Provides
    fun providesTeacherAttendanceDao(database: SccDatabase): TeacherAttendanceDao {
        return database.teacherAttendanceDao()
    }

    @Singleton
    @Provides
    fun providesTeacherBatchDao(database: SccDatabase): TeacherBatchDao {
        return database.teacherBatchDao()
    }

    @Singleton
    @Provides
    fun providesTeacherDao(database: SccDatabase): TeacherDao {
        return database.teacherDao()
    }

    @Singleton
    @Provides
    fun providesSubjectDao(database: SccDatabase): SubjectDao {
        return database.subjectDao()
    }

    @Singleton
    @Provides
    fun providesBatchTimeTableDao(database: SccDatabase): BatchTimeTableDao {
        return database.batchTimeTableDao()

    }

}