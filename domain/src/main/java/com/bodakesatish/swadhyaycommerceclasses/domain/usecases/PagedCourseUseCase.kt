package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import androidx.paging.PagingData
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.CourseRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PagedCourseUseCase @Inject constructor(private val courseRepository: CourseRepository) :
    BaseUseCase<PagedCourseUseCase.Request, PagedCourseUseCase.Response, Any, Flow<PagingData<Course>>>() {

    override suspend fun buildUseCase(request: Request): Response {
        return courseRepository.getPagedCourses(request)
    }

    class Request : BaseUseCase.Request<Any>()

    class Response : BaseUseCase.Response<Flow<PagingData<Course>>>()

}