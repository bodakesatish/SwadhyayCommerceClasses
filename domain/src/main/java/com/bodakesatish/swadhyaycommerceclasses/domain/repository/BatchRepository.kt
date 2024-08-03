package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase

interface BatchRepository {
    suspend fun getAllBatches(request: BatchListUseCase.Request): BatchListUseCase.Response
    suspend fun addBatch(request: AddBatchUseCase.Request): AddBatchUseCase.Response
}