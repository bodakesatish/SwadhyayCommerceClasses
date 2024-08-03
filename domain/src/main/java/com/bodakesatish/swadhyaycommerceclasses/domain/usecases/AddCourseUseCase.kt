package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class AddCourseUseCase @Inject constructor(private val courseRepository: CourseRepository) :
    BaseUseCase<AddCourseUseCase.Request, AddCourseUseCase.Response, Course, Long>() {

    override suspend fun buildUseCase(request: Request): Response {
        return courseRepository.addCourse(request)
    }

    class Request : BaseUseCase.Request<Course>()

    class Response : BaseUseCase.Response<Long>()

}