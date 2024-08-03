package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.BatchDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import javax.inject.Inject

class BatchRepositoryImpl
@Inject
constructor(
    private val localDataSource: BatchDataSourceLocal
) : BatchRepository {

    override suspend fun getAllBatches(request: BatchListUseCase.Request): BatchListUseCase.Response {
        Log.i("In BatchRepositoryImpl", "getAllBatches")
        val response = BatchListUseCase.Response()
        val output = localDataSource.getAllBatches()
        val baseOutputMapper = BaseOutputRemoteMapper<List<Batch>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addBatch(request: AddBatchUseCase.Request): AddBatchUseCase.Response {
        Log.i("In BatchRepositoryImpl", "addBatch")
        val response = AddBatchUseCase.Response()
        val output = localDataSource.addBatch(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

}