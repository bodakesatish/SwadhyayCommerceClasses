package com.bodakesatish.swadhyaycommerceclasses.data.mapper

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.AuthEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.AuthToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationEntityLocalMapper
@Inject constructor() : BaseMapper<AuthToken, AuthEntity>() {
    override fun reverse(model: AuthToken): AuthEntity {
        return AuthEntity(
            0,
            model.userId,
            model.token,
            model.expiration)
    }

    override fun map(entity: AuthEntity): AuthToken {
        val accessToken = AuthToken()
        accessToken.userId = entity.userId
        accessToken.token = entity.token
        accessToken.expiration = entity.expirationTime
        return accessToken
    }
}