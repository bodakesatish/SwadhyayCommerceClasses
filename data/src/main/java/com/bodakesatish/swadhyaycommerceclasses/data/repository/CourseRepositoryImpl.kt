package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.CourseDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.PagedCourseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CourseRepositoryImpl
@Inject
constructor(
    private val localDataSource: CourseDataSourceLocal
) : CourseRepository {

    private val tag = this.javaClass.simpleName

    override suspend fun getAllCourses(request: CourseListUseCase.Request): CourseListUseCase.Response {
        Log.i("In $tag", "getAllCourses")
        val response = CourseListUseCase.Response()
        val local = localDataSource.getAllCourses()
        val output = (local as BaseOutput.Success).output
        response.setResponseCode(ResponseCode.Success)
        response.setData(output)
        return response
    }

    override suspend fun addCourse(request: AddCourseUseCase.Request): AddCourseUseCase.Response {
        Log.i("In $tag", "addCourse")
        val response = AddCourseUseCase.Response()
        val output = localDataSource.addCourse(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Long>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun getPagedCourses(request: PagedCourseUseCase.Request): PagedCourseUseCase.Response {
        Log.i("In $tag", "getPagedCourses")
        val response = PagedCourseUseCase.Response()
        val local = localDataSource.getPagedCourses()
        val output = (local as BaseOutput.Success).output
        response.setResponseCode(ResponseCode.Success)
        response.setData(output)
        return response
    }

}