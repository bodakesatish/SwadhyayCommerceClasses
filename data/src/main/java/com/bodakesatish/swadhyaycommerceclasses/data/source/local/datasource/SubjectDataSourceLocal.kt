package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.SubjectEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.SubjectDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectDataSourceLocal @Inject
constructor(
    private val subjectDao: SubjectDao,
    private val mapper: SubjectEntityLocalMapper
) : DataSource.SubjectDataSource {

    override suspend fun getSubjectList(request: SubjectListUseCase.Request): BaseOutput<List<Subject>> {
        val data = subjectDao.getSubjectListByCourseId(request.getRequestModel())
        Log.i("SubjectDataSourceLocal","getSubjectList->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }

    override suspend fun addSubject(request: AddSubjectUseCase.Request): BaseOutput<Long> {
        Log.i("SubjectDataSourceLocal","Model->${request.getRequestModel()}")
        val data = subjectDao.addSubject(mapper.reverse(request.getRequestModel()))
        Log.i("SubjectDataSourceLocal","addSubject->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, data)
    }
}
