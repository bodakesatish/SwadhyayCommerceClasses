package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class BatchListUseCase @Inject constructor(val repository: BatchRepository): BaseUseCase<BatchListUseCase.Request, BatchListUseCase.Response, Any, List<BatchDetail>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.getAllBatches(request)
    }

    class Request : BaseUseCase.Request<Any>()

    class Response : BaseUseCase.Response<List<BatchDetail>>()

}