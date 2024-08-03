package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class AddBatchUseCase @Inject constructor(val repository: BatchRepository): BaseUseCase<AddBatchUseCase.Request, AddBatchUseCase.Response, Batch, Boolean>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.addBatch(request)
    }

    class Request : BaseUseCase.Request<Batch>()

    class Response : BaseUseCase.Response<Boolean>()

}