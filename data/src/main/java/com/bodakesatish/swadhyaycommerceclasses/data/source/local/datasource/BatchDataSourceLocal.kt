package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.BatchDetailEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.BatchEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.BatchDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatchDataSourceLocal
@Inject
constructor(
    private val batchDao: BatchDao,
    private val mapper: BatchEntityLocalMapper,
    private val batchDetailMapper: BatchDetailEntityLocalMapper
) : DataSource.BatchDataSource {

    val tag = this::class.simpleName

    init {
        Log.i(tag, "BatchDataSourceLocal Init")
    }

    override suspend fun getAllBatches(): BaseOutput<List<Batch>> {
        val data = batchDao.getAllBatches()
        Log.i(tag,"getAllBatches->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))

    }

    override suspend fun addBatch(request: AddBatchUseCase.Request): BaseOutput<Boolean> {
        Log.i(tag,"Model->${request.getRequestModel()}")
        val data = batchDao.addBatch(mapper.reverse(request.getRequestModel()))
        Log.i(tag,"addBatch->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }

    override suspend fun getBatchList(): BaseOutput<List<BatchDetail>> {
        Log.i(tag,"Model->}")
        val data = batchDao.getBatchList()
        Log.i(tag,"getBatchList->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, batchDetailMapper.map(data))
    }

    override suspend fun getFilteredBatchList(request: FilteredBatchListUseCase.Request): BaseOutput<List<Batch>> {
        Log.i(tag,"Model->${request.getRequestModel()}")
        val data = batchDao.getFilteredBatchList(request.getRequestModel().courseId, request.getRequestModel().subjectId)
        Log.i(tag,"getFilteredBatchList->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
    }
}