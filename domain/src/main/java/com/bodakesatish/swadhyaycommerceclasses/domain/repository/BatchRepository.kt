package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CreateBatchTimeTableUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetBatchTimeTableUseCase

interface BatchRepository {
    suspend fun getAllBatches(request: BatchListUseCase.Request): BatchListUseCase.Response
    suspend fun addBatch(request: AddBatchUseCase.Request): AddBatchUseCase.Response
    suspend fun getFilteredBatchList(request: FilteredBatchListUseCase.Request): FilteredBatchListUseCase.Response
    suspend fun createBatchTimeTable(request: CreateBatchTimeTableUseCase.Request): CreateBatchTimeTableUseCase.Response
    suspend fun getBatchTimeTable(request: GetBatchTimeTableUseCase.Request): GetBatchTimeTableUseCase.Response
}