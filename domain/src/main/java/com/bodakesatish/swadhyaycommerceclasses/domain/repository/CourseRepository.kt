package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase

interface CourseRepository {
    suspend fun getAllCourses(request: CourseListUseCase.Request): CourseListUseCase.Response
    suspend fun addCourse(request: AddCourseUseCase.Request): AddCourseUseCase.Response
}