package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.LoginDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.LoginRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SocialMediaSignInUseCase
import javax.inject.Inject

class LoginRepositoryImpl
@Inject
constructor(
    private val localDataSource: LoginDataSourceLocal
) : LoginRepository
{
    override suspend fun signInFromSocialMedia(request: SocialMediaSignInUseCase.Request): SocialMediaSignInUseCase.Response {
        Log.i("In FMCRepositoryImpl", "signInFromSocialMedia")
        val output = BaseOutput.Error(ResponseCode.EMPTY)
        val response = SocialMediaSignInUseCase.Response()
        val baseOutputMapper = BaseOutputRemoteMapper<AuthToken>()
        baseOutputMapper.mapBaseOutput(output, response,
            executeOnSuccess = {
                localDataSource.saveAuthToken(it)
                val localOutput = localDataSource.signInFromSocialMedia(request)
                if (localOutput is BaseOutput.Success) {
                    return@mapBaseOutput localOutput.output!!
                } else {
                    return@mapBaseOutput AuthToken()
                }
            }, executeOnError = {
                return@mapBaseOutput AuthToken()
            })
        return response
    }

}