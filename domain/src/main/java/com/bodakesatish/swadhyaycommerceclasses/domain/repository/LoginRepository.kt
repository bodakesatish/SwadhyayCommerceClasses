package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase

interface LoginRepository {
    suspend fun login(request: LoginUseCase.Request) : LoginUseCase.Response
}