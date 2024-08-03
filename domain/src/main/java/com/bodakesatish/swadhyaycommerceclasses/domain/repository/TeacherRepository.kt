package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.TeacherListUseCase

interface TeacherRepository {
    suspend fun getAllTeachers(request: TeacherListUseCase.Request): TeacherListUseCase.Response
    suspend fun addTeacher(request: AddTeacherUseCase.Request): AddTeacherUseCase.Response
}