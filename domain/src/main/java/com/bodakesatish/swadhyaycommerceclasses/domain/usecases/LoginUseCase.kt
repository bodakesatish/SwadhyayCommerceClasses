package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.UserRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.UserResponseModel
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.LoginRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val fmcRepository: LoginRepository) :
    BaseUseCase<LoginUseCase.Request, LoginUseCase.Response, UserRequestModel, UserResponseModel>() {

    override suspend fun buildUseCase(request: Request): Response {
        Log.i("In LoginUseCase","LoginUseCase")
        return fmcRepository.login(request)
    }

    class Request : BaseUseCase.Request<UserRequestModel>()

    class Response : BaseUseCase.Response<UserResponseModel>()

}