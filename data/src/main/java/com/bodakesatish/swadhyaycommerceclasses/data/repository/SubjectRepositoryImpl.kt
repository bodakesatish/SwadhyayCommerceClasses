package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.SubjectDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.SubjectRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import javax.inject.Inject

class SubjectRepositoryImpl
@Inject
constructor(
    private val localDataSource: SubjectDataSourceLocal
) : SubjectRepository {
    override suspend fun getSubjectList(request: SubjectListUseCase.Request): SubjectListUseCase.Response {
        Log.i("In SubjectRepositoryImpl", "getSubjectList")
        val response = SubjectListUseCase.Response()
        val output = localDataSource.getSubjectList(request)
        val baseOutputMapper = BaseOutputRemoteMapper<List<Subject>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addSubject(request: AddSubjectUseCase.Request): AddSubjectUseCase.Response {
        Log.i("In SubjectRepositoryImpl", "addSubject")
        val response = AddSubjectUseCase.Response()
        val output = localDataSource.addSubject(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Long>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

}