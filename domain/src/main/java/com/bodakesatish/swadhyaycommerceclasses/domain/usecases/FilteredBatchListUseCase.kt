package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.AddStudentBatchRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.BatchRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class FilteredBatchListUseCase @Inject constructor(val repository: BatchRepository): BaseUseCase<FilteredBatchListUseCase.Request, FilteredBatchListUseCase.Response, AddStudentBatchRequestModel, List<Batch>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.getFilteredBatchList(request)
    }

    class Request : BaseUseCase.Request<AddStudentBatchRequestModel>()

    class Response : BaseUseCase.Response<List<Batch>>()

}