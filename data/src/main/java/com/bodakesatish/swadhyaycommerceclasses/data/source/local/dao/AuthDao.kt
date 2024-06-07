package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.AuthData

@Dao
interface AuthDao : BaseDao<AuthData> {

    @Query("SELECT * from table_auth where id = 0")
    suspend fun getAccessData(): AuthData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(authData: AuthData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(authData: AuthData)

    @Query("DELETE FROM table_auth")
    suspend fun deleteAll()
}