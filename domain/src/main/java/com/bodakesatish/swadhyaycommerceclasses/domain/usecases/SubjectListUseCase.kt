package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.SubjectRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class SubjectListUseCase @Inject constructor(private val subjectRepository: SubjectRepository) :
    BaseUseCase<SubjectListUseCase.Request, SubjectListUseCase.Response, Int, List<Subject>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return subjectRepository.getSubjectList(request)
    }

    class Request : BaseUseCase.Request<Int>()

    class Response : BaseUseCase.Response<List<Subject>>()

}