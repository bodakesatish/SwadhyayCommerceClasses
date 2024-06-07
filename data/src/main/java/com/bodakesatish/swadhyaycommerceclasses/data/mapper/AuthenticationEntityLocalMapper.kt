package com.bodakesatish.swadhyaycommerceclasses.data.mapper

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.AuthData
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationEntityLocalMapper
@Inject constructor() : BaseMapper<AuthToken, AuthData>() {
    override fun reverse(model: AuthToken): AuthData {
        return AuthData(
            0,
            model.userId,
            model.token,
            model.expiration)
    }

    override fun map(entity: AuthData): AuthToken {
        val accessToken = AuthToken()
        accessToken.userId = entity.userId
        accessToken.token = entity.token
        accessToken.expiration = entity.expirationTime
        return accessToken
    }
}