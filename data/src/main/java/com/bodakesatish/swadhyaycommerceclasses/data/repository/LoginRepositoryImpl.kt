package com.bodakesatish.swadhyaycommerceclasses.data.repository

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseOutputRemoteMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource.LoginDataSourceLocal
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.UserResponseModel
import com.bodakesatish.swadhyaycommerceclasses.domain.repository.LoginRepository
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase
import javax.inject.Inject

class LoginRepositoryImpl
@Inject
constructor(
    private val localDataSource: LoginDataSourceLocal
) : LoginRepository
{
    override suspend fun login(request: LoginUseCase.Request): LoginUseCase.Response {
        Log.i("In LoginRepositoryImpl", "LoginRepository")
        val output = localDataSource.login(request)
        val response = LoginUseCase.Response()
        val baseOutputMapper = BaseOutputRemoteMapper<UserResponseModel>()
        baseOutputMapper.mapBaseOutput(output, response,
            executeOnSuccess = {
                if (output is BaseOutput.Success) {
                    Log.i("In LoginRepositoryImpl", "login Success")
                    return@mapBaseOutput output.output!!
                } else {
                    Log.i("In LoginRepositoryImpl", "login Not Success")
                    return@mapBaseOutput UserResponseModel()
                }
            }, executeOnError = {
                Log.i("In LoginRepositoryImpl", "login Error")
                return@mapBaseOutput UserResponseModel()
            })
        return response
    }

}