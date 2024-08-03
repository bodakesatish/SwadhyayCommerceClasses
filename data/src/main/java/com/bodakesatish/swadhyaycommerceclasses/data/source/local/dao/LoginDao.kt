package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.LoginEntity

@Dao
interface LoginDao : BaseDao<LoginEntity> {

    @Query("SELECT * from ${LoginEntity.TABLE_NAME} where ${LoginEntity.Columns.USER_NAME} = :username and ${LoginEntity.Columns.PASSWORD} = :password")
    fun validateLogin(username: String, password: String): LoginEntity?

}