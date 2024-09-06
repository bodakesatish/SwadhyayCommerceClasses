package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.StudentEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.StudentDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.DeleteStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetStudentByIdUseCase
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

    override suspend fun getStudentNyId(request: GetStudentByIdUseCase.Request): BaseOutput<Student> {
        val data = studentDao.getStudentById(request.getRequestModel())
        Log.i("StudentDataSourceLocal","getStudentNyId->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }

    override suspend fun addOrUpdateStudent(request: AddStudentUseCase.Request): BaseOutput<Boolean> {
        Log.i("StudentDataSourceLocal","Model->${request.getRequestModel()}")
        val data = studentDao.addOrUpdateStudent(mapper.reverse(request.getRequestModel()))
        Log.i("StudentDataSourceLocal","addOrUpdateStudent->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }

    override suspend fun deleteStudent(request: DeleteStudentUseCase.Request): BaseOutput<Boolean> {
        Log.i("StudentDataSourceLocal","request->${request.getRequestModel()}")
        val data = studentDao.deleteStudent(request.getRequestModel().studentId)
        Log.i("StudentDataSourceLocal","deleteStudent->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }

}