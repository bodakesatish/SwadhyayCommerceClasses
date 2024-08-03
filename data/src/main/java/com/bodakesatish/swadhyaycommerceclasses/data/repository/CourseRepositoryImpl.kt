package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.CourseDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import javax.inject.Inject

class CourseRepositoryImpl
@Inject
constructor(
    private val localDataSource: CourseDataSourceLocal
) : CourseRepository {

    override suspend fun getAllCourses(request: CourseListUseCase.Request): CourseListUseCase.Response {
        Log.i("In CourseRepositoryImpl", "getAllCourses")
        val response = CourseListUseCase.Response()
        val output = localDataSource.getAllCourses()
        val baseOutputMapper = BaseOutputRemoteMapper<List<Course>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addCourse(request: AddCourseUseCase.Request): AddCourseUseCase.Response {
        Log.i("In CourseRepositoryImpl", "addCourse")
        val response = AddCourseUseCase.Response()
        val output = localDataSource.addCourse(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Long>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

}