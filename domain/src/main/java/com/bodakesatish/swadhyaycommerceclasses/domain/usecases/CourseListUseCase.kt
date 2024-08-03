package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class CourseListUseCase @Inject constructor(private val courseRepository: CourseRepository) :
    BaseUseCase<CourseListUseCase.Request, CourseListUseCase.Response, Any, List<Course>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return courseRepository.getAllCourses(request)
    }

    class Request : BaseUseCase.Request<Any>()

    class Response : BaseUseCase.Response<List<Course>>()

}