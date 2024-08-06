package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase

interface BatchRepository {
    suspend fun getAllBatches(request: BatchListUseCase.Request): BatchListUseCase.Response
    suspend fun addBatch(request: AddBatchUseCase.Request): AddBatchUseCase.Response
    suspend fun getFilteredBatchList(request: FilteredBatchListUseCase.Request): FilteredBatchListUseCase.Response
}