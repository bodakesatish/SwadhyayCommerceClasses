package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity

@Entity(tableName = LoginEntity.TABLE_NAME)
data class LoginEntity(
    @PrimaryKey
    @ColumnInfo(name = Columns.USER_ID)
    val userId: Int = 0,
    @ColumnInfo(name = Columns.NAME)
    val name: String = "",
    @ColumnInfo(name = Columns.EMAIL)
    val email: String = "",
    @ColumnInfo(name = Columns.PASSWORD)
    val password: String = "",
    @ColumnInfo(name = Columns.USER_TYPE)
    val userType: String = "",//superadmin/admin/teacher/accountant/parent
    @ColumnInfo(name = Columns.USER_NAME)
    val userName: String = "",
    @ColumnInfo(name = Columns.USER_IMAGE)
    val userImage: String = "",
    @ColumnInfo(name = Columns.IS_ACTIVE)
    val isActive: Boolean = false,
) : BaseEntity() {

    companion object {

        const val TABLE_NAME = "LoginEntity"

    }

    internal object Columns {

        internal const val USER_ID = "userId"

        internal const val NAME = "name"

        internal const val EMAIL = "email"

        internal const val PASSWORD = "password"

        internal const val USER_TYPE = "userType"

        internal const val USER_NAME = "userName"

        internal const val USER_IMAGE = "userImage"

        internal const val IS_ACTIVE = "isActive"

    }
}