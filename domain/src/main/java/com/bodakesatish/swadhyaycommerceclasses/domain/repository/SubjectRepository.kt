package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase

interface SubjectRepository {
    suspend fun getSubjectList(request: SubjectListUseCase.Request): SubjectListUseCase.Response
    suspend fun addSubject(request: AddSubjectUseCase.Request): AddSubjectUseCase.Response
}