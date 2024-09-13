package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.CourseEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.CourseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.paging.CoursePagingSource
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourseDataSourceLocal
@Inject
constructor(
    private val courseDao: CourseDao,
    private val mapper: CourseEntityLocalMapper
) : DataSource.CourseDataSource {

    private val tag = this.javaClass.simpleName

    override suspend fun getAllCourses(): BaseOutput<Flow<List<Course>>> {
        val data = courseDao.getAllCourses().map { courseList ->
            mapper.map(courseList)
        }
        Log.i("CourseDataSourceLocal","getAllCourses->$data")
        return if (data.firstOrNull()?.isEmpty() == true) {
            BaseOutput.Success(ResponseCode.EMPTY, data)
        } else {
            BaseOutput.Success(ResponseCode.SUCCESS, data)
        }
    }

    override suspend fun addCourse(request: AddCourseUseCase.Request): BaseOutput<Long> {
        Log.i("CourseDataSourceLocal","Model->${request.getRequestModel()}")
        val data = courseDao.addCourse(mapper.reverse(request.getRequestModel()))
        Log.i("CourseDataSourceLocal","addCourse->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, data)
    }

    override suspend fun getPagedCourses(): BaseOutput<Flow<PagingData<Course>>> {
        Log.i("In $tag", "getPagedCourses")
        val pager = Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CoursePagingSource(courseDao, mapper) }
        ).flow

        Log.i("In $tag", "getPagedCourses $pager")

        return BaseOutput.Success(ResponseCode.SUCCESS, pager)
    }


}