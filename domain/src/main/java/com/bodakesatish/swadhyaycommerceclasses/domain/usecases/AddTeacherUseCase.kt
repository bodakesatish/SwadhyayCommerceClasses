package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.TeacherRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class AddTeacherUseCase @Inject constructor(val repository: TeacherRepository) :
    BaseUseCase<AddTeacherUseCase.Request, AddTeacherUseCase.Response, Teacher, Boolean>() {

        override suspend fun buildUseCase(request: Request): Response {
            return repository.addTeacher(request)
        }

        class Request : BaseUseCase.Request<Teacher>()

        class Response : BaseUseCase.Response<Boolean>()
    }