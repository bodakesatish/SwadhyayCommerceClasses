package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.StudentEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.StudentDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentDataSourceLocal
@Inject
constructor(
    private val studentDao: StudentDao,
    private val mapper: StudentEntityLocalMapper
) : DataSource.StudentDataSource {

    override suspend fun getAllStudents(): BaseOutput<List<Student>> {
        val data = studentDao.getAllStudents()
        Log.i("StudentDataSourceLocal","getAllStudents->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }

    override suspend fun addStudent(request: AddStudentUseCase.Request): BaseOutput<Boolean> {
        Log.i("StudentDataSourceLocal","Model->${request.getRequestModel()}")
        val data = studentDao.addStudent(mapper.reverse(request.getRequestModel()))
        Log.i("StudentDataSourceLocal","addTeacher->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }

}