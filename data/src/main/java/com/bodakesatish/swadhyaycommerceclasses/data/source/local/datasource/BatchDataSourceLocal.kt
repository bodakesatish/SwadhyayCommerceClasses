package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.local.BatchEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.BatchDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BatchDataSourceLocal
@Inject
constructor(
    private val batchDao: BatchDao,
    private val mapper: BatchEntityLocalMapper
) : DataSource.BatchDataSource {

    override suspend fun getAllBatches(): BaseOutput<List<Batch>> {
        val data = batchDao.getAllBatches()
        Log.i("BatchDataSourceLocal","getAllBatches->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))

    }

    override suspend fun addBatch(request: AddBatchUseCase.Request): BaseOutput<Boolean> {
        Log.i("BatchDataSourceLocal","Model->${request.getRequestModel()}")
        val data = batchDao.addBatch(mapper.reverse(request.getRequestModel()))
        Log.i("BatchDataSourceLocal","addBatch->$data")
        return BaseOutput.Success(ResponseCode.SUCCESS, true)
    }
}