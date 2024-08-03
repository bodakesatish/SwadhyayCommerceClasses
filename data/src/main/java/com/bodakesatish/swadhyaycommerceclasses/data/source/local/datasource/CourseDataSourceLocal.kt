package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.CourseEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.CourseDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourseDataSourceLocal
@Inject
constructor(
    private val courseDao: CourseDao,
    private val mapper: CourseEntityLocalMapper
) : DataSource.CourseDataSource {

    override suspend fun getAllCourses(): BaseOutput<List<Course>> {
        val data = courseDao.getAllCourses()
        Log.i("CourseDataSourceLocal","getAllCourses->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }

    override suspend fun addCourse(request: AddCourseUseCase.Request): BaseOutput<Long> {
        Log.i("CourseDataSourceLocal","Model->${request.getRequestModel()}")
        val data = courseDao.addCourse(mapper.reverse(request.getRequestModel()))
        Log.i("CourseDataSourceLocal","addCourse->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, data)
    }


}