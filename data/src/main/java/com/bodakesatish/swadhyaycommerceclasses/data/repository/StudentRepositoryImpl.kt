package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.StudentDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.DeleteStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetStudentByIdUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.StudentListUseCase
import javax.inject.Inject

class StudentRepositoryImpl
@Inject
constructor(
    private val localDataSource: StudentDataSourceLocal
) : StudentRepository {

    private val tag = this.javaClass.simpleName

    override suspend fun getAllStudents(request: StudentListUseCase.Request): StudentListUseCase.Response {
        Log.i(tag, "In $tag getAllStudents")
        val response = StudentListUseCase.Response()
        val output = localDataSource.getAllStudents()
        val baseOutputMapper = BaseOutputRemoteMapper<List<Student>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun getStudentById(request: GetStudentByIdUseCase.Request):  GetStudentByIdUseCase.Response {
        Log.i(tag, "In $tag getStudentById")
        val response = GetStudentByIdUseCase.Response()
        val output = localDataSource.getStudentNyId(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Student>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addOrUpdateStudent(request: AddStudentUseCase.Request): AddStudentUseCase.Response {
        Log.i(tag, "In $tag addStudent")
        val response = AddStudentUseCase.Response()
        val output = localDataSource.addOrUpdateStudent(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun deleteStudent(request: DeleteStudentUseCase.Request): DeleteStudentUseCase.Response {
        Log.i(tag, "In $tag deleteStudent")
        val response = DeleteStudentUseCase.Response()
        val output = localDataSource.deleteStudent(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }


}