package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class DeleteStudentUseCase @Inject constructor(val repository: StudentRepository): BaseUseCase<DeleteStudentUseCase.Request, DeleteStudentUseCase.Response, Student, Boolean>()
{
    override suspend fun buildUseCase(request: Request): Response {
        return repository.deleteStudent(request)
    }

    class Request : BaseUseCase.Request<Student>()

    class Response : BaseUseCase.Response<Boolean>()

}