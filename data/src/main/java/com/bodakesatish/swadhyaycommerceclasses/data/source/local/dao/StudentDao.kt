package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentData

@Dao
interface  StudentDao : BaseDao<StudentData> {

    @Query("SELECT * from table_student where _id = :id")
    suspend fun getStudentData(id: Int): StudentData?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(authData: StudentData)

}