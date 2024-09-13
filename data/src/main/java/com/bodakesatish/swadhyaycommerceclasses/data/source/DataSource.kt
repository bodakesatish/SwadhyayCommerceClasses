package com.bodakesatish.swadhyaycommerceclasses.data.source

import androidx.paging.PagingData
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchTimeTable
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CreateBatchTimeTableUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.DeleteStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetBatchTimeTableUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetStudentByIdUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import kotlinx.coroutines.flow.Flow

class DataSource {

    interface LoginDataSource {
        suspend fun login(requestModel: LoginUseCase.Request): BaseOutput<Any>
    }

    interface CourseDataSource {
        suspend fun getAllCourses(): BaseOutput<Flow<List<Course>>>
        suspend fun addCourse(request: AddCourseUseCase.Request): BaseOutput<Long>
        suspend fun getPagedCourses(): BaseOutput<Flow<PagingData<Course>>>
    }

    interface SubjectDataSource {
        suspend fun addSubject(request: AddSubjectUseCase.Request): BaseOutput<Long>
        suspend fun getSubjectList(request: SubjectListUseCase.Request): BaseOutput<List<Subject>>
    }

    interface BatchDataSource {
        suspend fun getAllBatches(): BaseOutput<List<Batch>>
        suspend fun addBatch(request: AddBatchUseCase.Request): BaseOutput<Boolean>
        suspend fun getBatchList(): BaseOutput<List<BatchDetail>>
        suspend fun getFilteredBatchList(request: FilteredBatchListUseCase.Request): BaseOutput<List<Batch>>
        suspend fun createBatchTimeTable(request: CreateBatchTimeTableUseCase.Request): BaseOutput<Boolean>
        suspend fun getBatchTimeTable(request: GetBatchTimeTableUseCase.Request): BaseOutput<List<BatchTimeTable>>
    }

    interface TeacherDataSource {
        suspend fun getAllTeachers(): BaseOutput<List<Teacher>>
        suspend fun addTeacher(request: AddTeacherUseCase.Request): BaseOutput<Boolean>
    }

    interface StudentDataSource {
        suspend fun getAllStudents(): BaseOutput<List<Student>>
        suspend fun getStudentNyId(request: GetStudentByIdUseCase.Request): BaseOutput<Student>
        suspend fun addOrUpdateStudent(request: AddStudentUseCase.Request): BaseOutput<Boolean>
        suspend fun deleteStudent(request: DeleteStudentUseCase.Request): BaseOutput<Boolean>
    }

}