package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.PagedCourseUseCase

interface CourseRepository {
    suspend fun getAllCourses(request: CourseListUseCase.Request): CourseListUseCase.Response
    suspend fun addCourse(request: AddCourseUseCase.Request): AddCourseUseCase.Response
    suspend fun getPagedCourses(request: PagedCourseUseCase.Request): PagedCourseUseCase.Response
}