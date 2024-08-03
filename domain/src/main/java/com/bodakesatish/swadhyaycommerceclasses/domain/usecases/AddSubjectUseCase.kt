package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.SubjectRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class AddSubjectUseCase @Inject constructor(private val subjectRepository: SubjectRepository) :
    BaseUseCase<AddSubjectUseCase.Request, AddSubjectUseCase.Response, Subject, Long>() {

    override suspend fun buildUseCase(request: AddSubjectUseCase.Request): AddSubjectUseCase.Response {
        return subjectRepository.addSubject(request)
    }

    class Request : BaseUseCase.Request<Subject>()

    class Response : BaseUseCase.Response<Long>()

}