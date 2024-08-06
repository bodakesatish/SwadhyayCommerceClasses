package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.BatchDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase
import javax.inject.Inject

class BatchRepositoryImpl
@Inject
constructor(
    private val localDataSource: BatchDataSourceLocal
) : BatchRepository {

    val tag = this::class.simpleName

    override suspend fun getAllBatches(request: BatchListUseCase.Request): BatchListUseCase.Response {
        Log.i(tag, "getAllBatches")
        val response = BatchListUseCase.Response()
        val output = localDataSource.getBatchList()
        localDataSource.getBatchList()
        val baseOutputMapper = BaseOutputRemoteMapper<List<BatchDetail>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun addBatch(request: AddBatchUseCase.Request): AddBatchUseCase.Response {
        Log.i(tag, "addBatch")
        val response = AddBatchUseCase.Response()
        val output = localDataSource.addBatch(request)
        val baseOutputMapper = BaseOutputRemoteMapper<Boolean>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

    override suspend fun getFilteredBatchList(request: FilteredBatchListUseCase.Request): FilteredBatchListUseCase.Response {
        Log.i(tag, "getFilteredBatchList")
        val response = FilteredBatchListUseCase.Response()
        val output = localDataSource.getFilteredBatchList(request)
        val baseOutputMapper = BaseOutputRemoteMapper<List<Batch>>()
        baseOutputMapper.mapBaseOutput(output, response)
        return response
    }

}