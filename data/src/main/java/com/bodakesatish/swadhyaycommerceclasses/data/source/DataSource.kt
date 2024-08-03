package com.bodakesatish.swadhyaycommerceclasses.data.source

import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase

class DataSource {

    interface LoginDataSource {
        suspend fun login(requestModel: LoginUseCase.Request): BaseOutput<Any>
    }

    interface CourseDataSource {
        suspend fun getAllCourses(): BaseOutput<List<Course>>
        suspend fun addCourse(request: AddCourseUseCase.Request): BaseOutput<Long>
    }

    interface SubjectDataSource {
        suspend fun addSubject(request: AddSubjectUseCase.Request): BaseOutput<Long>
        suspend fun getSubjectList(request: SubjectListUseCase.Request): BaseOutput<List<Subject>>
    }

    interface BatchDataSource {
        suspend fun getAllBatches(): BaseOutput<List<Batch>>
        suspend fun addBatch(request: AddBatchUseCase.Request): BaseOutput<Boolean>
    }

    interface TeacherDataSource {
        suspend fun getAllTeachers(): BaseOutput<List<Teacher>>
        suspend fun addTeacher(request: AddTeacherUseCase.Request): BaseOutput<Boolean>
    }

    interface StudentDataSource {
        suspend fun getAllStudents(): BaseOutput<List<Student>>
        suspend fun addStudent(request: AddStudentUseCase.Request): BaseOutput<Boolean>
    }

}