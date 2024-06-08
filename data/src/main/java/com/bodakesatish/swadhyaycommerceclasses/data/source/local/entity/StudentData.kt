package com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseEntity

@Entity(tableName = "table_student")
class StudentData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id: Int,

    @ColumnInfo("name")
    val name: String,

    @ColumnInfo("standard")
    val standard: String,

    @ColumnInfo("phone")
    val phone: String,

    @ColumnInfo("email")
    val email: String,

    @ColumnInfo("address")
    val address: String,

    @ColumnInfo("gender")
    val gender: String,

    @ColumnInfo("dob")
    val dob: String,

    @ColumnInfo("image")
    val image: String,

    @ColumnInfo("parent_phone")
    val parent_phone: String,

    @ColumnInfo("created_at")
    val created_at: String,

    @ColumnInfo("updated_at")
    val updated_at: String,

    @ColumnInfo("deleted_at")
    val deleted_at: String,

) : BaseEntity()