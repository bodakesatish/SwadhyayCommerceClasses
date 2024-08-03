package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity

@Entity(tableName = "table_access")
class AuthEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id : Int = 0,
    @ColumnInfo(name = "userId")
    val userId : Int = 0,
    @ColumnInfo(name = "token")
    val token : String,
    @ColumnInfo(name = "ExpirationTime")
    val expirationTime : Long
) : BaseEntity()