package com.bodakesatish.swadhyaycommerceclasses.domain.repository

import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SocialMediaSignInUseCase

interface LoginRepository {
    suspend fun signInFromSocialMedia(request: SocialMediaSignInUseCase.Request) : SocialMediaSignInUseCase.Response
}