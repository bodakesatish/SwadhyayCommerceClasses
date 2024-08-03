package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.StudentListUseCase

interface StudentRepository {
    suspend fun getAllStudents(request: StudentListUseCase.Request): StudentListUseCase.Response
//    suspend fun getStudentById(request: StudentListUseCase.Request): Student?
    suspend fun addStudent(request: AddStudentUseCase.Request): AddStudentUseCase.Response
//    suspend fun updateStudent(request: StudentListUseCase.Request): Int
//    suspend fun deleteStudent(request: StudentListUseCase.Request): Int
}