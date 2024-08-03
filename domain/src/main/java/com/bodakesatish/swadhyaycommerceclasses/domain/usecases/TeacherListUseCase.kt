package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.TeacherRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class TeacherListUseCase @Inject constructor(val repository: TeacherRepository) :
    BaseUseCase<TeacherListUseCase.Request, TeacherListUseCase.Response, Any, List<Teacher>>() {

        override suspend fun buildUseCase(request: Request): Response {
            return repository.getAllTeachers(request)
        }

        class Request : BaseUseCase.Request<Any>()

        class Response : BaseUseCase.Response<List<Teacher>>()
    }