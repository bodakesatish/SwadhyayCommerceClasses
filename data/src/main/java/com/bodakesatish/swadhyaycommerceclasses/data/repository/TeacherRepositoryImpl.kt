package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.TeacherDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.TeacherRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.TeacherListUseCase
import javax.inject.Inject

class TeacherRepositoryImpl
@Inject
constructor(
    private val localDataSource: TeacherDataSourceLocal
) : TeacherRepository {

    override suspend fun getAllTeachers(request: TeacherListUseCase.Request): TeacherListUseCase.Response {
        Log.i("In TeacherRepositoryImpl", "getAllTeachers")
        val response = TeacherListUseCase.Response()
        val output = localDataSource.getAllTeachers()
        val baseOutputMapper = BaseOutputRemoteMapper<List<Teacher>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addTeacher(request: AddTeacherUseCase.Request): AddTeacherUseCase.Response {
        Log.i("In TeacherRepositoryImpl", "addTeacher")
        val response = AddTeacherUseCase.Response()
        val output = localDataSource.addTeacher(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

}