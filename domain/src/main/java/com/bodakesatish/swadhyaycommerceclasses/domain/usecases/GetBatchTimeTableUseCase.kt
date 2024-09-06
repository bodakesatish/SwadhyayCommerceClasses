package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchTimeTable
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class GetBatchTimeTableUseCase @Inject constructor(val repository: BatchRepository): BaseUseCase<GetBatchTimeTableUseCase.Request, GetBatchTimeTableUseCase.Response, Int, List<BatchTimeTable>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.getBatchTimeTable(request)
    }

    class Request : BaseUseCase.Request<Int>()

    class Response : BaseUseCase.Response<List<BatchTimeTable>>()

}