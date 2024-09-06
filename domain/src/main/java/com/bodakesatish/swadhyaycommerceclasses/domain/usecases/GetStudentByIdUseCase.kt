package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class GetStudentByIdUseCase @Inject constructor(val repository: StudentRepository): BaseUseCase<GetStudentByIdUseCase.Request, GetStudentByIdUseCase.Response, Int , Student>()
{
    override suspend fun buildUseCase(request: Request): Response {
        return repository.getStudentById(request)
    }

    class Request : BaseUseCase.Request<Int>()

    class Response : BaseUseCase.Response<Student>()

}