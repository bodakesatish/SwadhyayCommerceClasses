package com.bodakesatish.swadhyaycommerceclasses.domain.usecases

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.UserRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.UserResponseModel
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.LoginRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase
import javax.inject.Inject

class SocialMediaSignInUseCase @Inject constructor(private val fmcRepository: LoginRepository) :
    BaseUseCase<SocialMediaSignInUseCase.Request, SocialMediaSignInUseCase.Response, UserRequestModel, AuthToken>() {

    override suspend fun buildUseCase(request: Request): Response {
        Log.i("In SocialMediaSignInUseCase","SocialMediaSignInUseCase")
        return fmcRepository.signInFromSocialMedia(request)
    }

    class Request : BaseUseCase.Request<UserRequestModel>()

    class Response : BaseUseCase.Response<AuthToken>()
}