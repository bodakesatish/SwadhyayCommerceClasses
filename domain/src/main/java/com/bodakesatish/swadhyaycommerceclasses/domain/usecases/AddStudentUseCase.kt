package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.StudentRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class AddStudentUseCase @Inject constructor(val repository: StudentRepository): BaseUseCase<AddStudentUseCase.Request, AddStudentUseCase.Response, Student, Boolean>()
{
    override suspend fun buildUseCase(request: Request): Response {
        return repository.addStudent(request)
    }

    class Request : BaseUseCase.Request<Student>()

    class Response : BaseUseCase.Response<Boolean>()

}