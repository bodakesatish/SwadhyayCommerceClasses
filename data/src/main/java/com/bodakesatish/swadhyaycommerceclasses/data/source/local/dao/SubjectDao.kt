package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.SubjectEntity

@Dao
interface SubjectDao : BaseDao<SubjectEntity> {

    @Query("SELECT * FROM ${SubjectEntity.TABLE_NAME} WHERE ${SubjectEntity.Columns.COURSE_ID} = :courseId")
    fun getSubjectListByCourseId(courseId: Int): List<SubjectEntity>

    @Query("SELECT * FROM ${SubjectEntity.TABLE_NAME} WHERE ${SubjectEntity.Columns.SUBJECT_ID} = :subjectId")
    fun getSubjectById(subjectId: Int): SubjectEntity?

    @Insert
    fun addSubject(subject: SubjectEntity) : Long

}