package com.bodakesatish.swadhyaycommerceclasses.data.source

import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SocialMediaSignInUseCase

class DataSource {
    interface LoginDataSource {
        suspend fun signInFromSocialMedia(request: SocialMediaSignInUseCase.Request): BaseOutput<Any>
    }

}