package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.AuthenticationEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.LoginDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.UserResponseModel
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginDataSourceLocal
@Inject
constructor(
    private val loginDao: LoginDao,
    private val mapper: AuthenticationEntityLocalMapper
) : DataSource.LoginDataSource {

    override suspend fun login(requestModel: LoginUseCase.Request): BaseOutput<UserResponseModel> {
        val data = loginDao.validateLogin(
            requestModel.getRequestModel().username,
            requestModel.getRequestModel().password
        )
        return if (data != null) {
            BaseOutput.Success(ResponseCode.SUCCESS, UserResponseModel())
        } else {
            BaseOutput.Error(ResponseCode.EMPTY)
        }

    }
}