package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class StudentListUseCase @Inject constructor(val repository: StudentRepository): BaseUseCase<StudentListUseCase.Request, StudentListUseCase.Response, Any, List<Student>>()
{
    override suspend fun buildUseCase(request: Request): Response {
        return repository.getAllStudents(request)
    }

    class Request : BaseUseCase.Request<Any>()

    class Response : BaseUseCase.Response<List<Student>>()

}