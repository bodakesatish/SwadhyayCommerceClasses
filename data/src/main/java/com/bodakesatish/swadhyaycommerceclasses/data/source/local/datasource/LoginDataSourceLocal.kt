package com.bodakesatish.swadhyaycommerceclasses.data.source.local.datasource

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.AuthenticationEntityLocalMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.DataSource
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao.AuthDao
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SocialMediaSignInUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginDataSourceLocal
@Inject
constructor(
    private val authDao: AuthDao,
    private val mapper: AuthenticationEntityLocalMapper
) : DataSource.LoginDataSource {

    suspend fun saveAuthToken(data: AuthToken) {
        Log.i("In AuthenticationDataSourceLocal", "saveAuthToken")
        authDao.insert(mapper.reverse(data))
    }
    override suspend fun signInFromSocialMedia(request: SocialMediaSignInUseCase.Request): BaseOutput<AuthToken> {
        val data = authDao.getAccessData()
        return if (data != null && data.id != -1) {
            BaseOutput.Success(ResponseCode.SUCCESS, mapper.map(data))
        } else {
            BaseOutput.Error(ResponseCode.EMPTY)
        }
    }
}