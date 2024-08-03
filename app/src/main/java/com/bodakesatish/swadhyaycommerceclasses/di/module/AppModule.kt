package com.bodakesatish.swadhyaycommerceclasses.di.module

import com.bodakesatish.swadhyaycommerceclasses.data.repository.BatchRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.data.repository.CourseRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.data.repository.LoginRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.data.repository.StudentRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.data.repository.SubjectRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.data.repository.TeacherRepositoryImpl
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.LoginRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.SubjectRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.TeacherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    internal abstract fun provideLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

    @Binds
    internal abstract fun provideCourseRepository(courseRepositoryImpl: CourseRepositoryImpl): CourseRepository

    @Binds
    internal abstract fun provideBatchRepository(batchRepositoryImpl: BatchRepositoryImpl): BatchRepository

    @Binds
    internal abstract fun provideTeacherRepository(teacherRepositoryImpl: TeacherRepositoryImpl): TeacherRepository

    @Binds
    internal abstract fun provideStudentRepository(studentRepositoryImpl: StudentRepositoryImpl): StudentRepository

    @Binds
    internal abstract fun provideSubjectRepository(subjectRepositoryImpl: SubjectRepositoryImpl): SubjectRepository
}