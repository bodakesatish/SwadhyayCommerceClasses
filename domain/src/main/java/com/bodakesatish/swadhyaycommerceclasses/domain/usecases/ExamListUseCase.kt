package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Exam
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.ExamRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class ExamListUseCase @Inject constructor(val repository: ExamRepository) :
    BaseUseCase<ExamListUseCase.Request, ExamListUseCase.Response, Any, List<Exam>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return repository.getAllExams(request)
    }

    class Request : BaseUseCase.Request<Any>()

    class Response : BaseUseCase.Response<List<Exam>>()

}