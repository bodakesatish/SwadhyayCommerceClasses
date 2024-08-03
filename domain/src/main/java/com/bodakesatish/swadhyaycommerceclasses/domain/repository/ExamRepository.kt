package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Exam
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.ExamListUseCase

interface ExamRepository {
    fun getAllExams(request: ExamListUseCase.Request): ExamListUseCase.Response
}