package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.DeleteStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetStudentByIdUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.StudentListUseCase

interface StudentRepository {
    suspend fun getAllStudents(request: StudentListUseCase.Request): StudentListUseCase.Response
    suspend fun getStudentById(request: GetStudentByIdUseCase.Request): GetStudentByIdUseCase.Response
    suspend fun addOrUpdateStudent(request: AddStudentUseCase.Request): AddStudentUseCase.Response
    suspend fun deleteStudent(request: DeleteStudentUseCase.Request): DeleteStudentUseCase.Response
}