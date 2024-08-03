package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.TeacherEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.TeacherDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeacherDataSourceLocal
@Inject
constructor(
    private val teacherDao: TeacherDao,
    private val mapper: TeacherEntityLocalMapper
) : DataSource.TeacherDataSource
{
    override suspend fun getAllTeachers(): BaseOutput<List<Teacher>> {
        val data = teacherDao.getAllTeachers()
        Log.i("TeacherDataSourceLocal","getAllTeachers->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }

    override suspend fun addTeacher(request: AddTeacherUseCase.Request): BaseOutput<Boolean> {
        Log.i("TeacherDataSourceLocal","Model->${request.getRequestModel()}")
        val data = teacherDao.addTeacher(mapper.reverse(request.getRequestModel()))
        Log.i("TeacherDataSourceLocal","addTeacher->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }

}