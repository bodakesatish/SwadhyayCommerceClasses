package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class CreateBatchTimeTableUseCase @Inject constructor(val repository: BatchRepository): BaseUseCase<CreateBatchTimeTableUseCase.Request, CreateBatchTimeTableUseCase.Response, Int, Boolean>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.createBatchTimeTable(request)
    }

    class Request : BaseUseCase.Request<Int>()

    class Response : BaseUseCase.Response<Boolean>()

}