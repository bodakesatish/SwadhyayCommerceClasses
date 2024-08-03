package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.StudentDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.StudentListUseCase
import javax.inject.Inject

class StudentRepositoryImpl
@Inject
constructor(
    private val localDataSource: StudentDataSourceLocal
) : StudentRepository {

    override suspend fun getAllStudents(request: StudentListUseCase.Request): StudentListUseCase.Response {
        Log.i("In StudentRepositoryImpl", "getAllStudents")
        val response = StudentListUseCase.Response()
        val output = localDataSource.getAllStudents()
        val baseOutputMapper = BaseOutputRemoteMapper<List<Student>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

//    override suspend fun getStudentById(request: StudentListUseCase.Request): Student? {
//        TODO("Not yet implemented")
//    }

    override suspend fun addStudent(request: AddStudentUseCase.Request): AddStudentUseCase.Response {
        Log.i("In StudentRepositoryImpl", "addStudent")
        val response = AddStudentUseCase.Response()
        val output = localDataSource.addStudent(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

//    override suspend fun updateStudent(request: StudentListUseCase.Request): Int {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun deleteStudent(request: StudentListUseCase.Request): Int {
//        TODO("Not yet implemented")
//    }

}