package com.bodakesatish.swadhyaycommerceclasses.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.base.BaseDao
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.BatchDetailEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.CourseEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.SubjectEntity
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch

@Dao
interface BatchDao : BaseDao<BatchEntity> {

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME}")
    fun getAllBatches(): List<BatchEntity>

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME} WHERE ${BatchEntity.Columns.BATCH_ID} = :batchId")
    fun getBatchById(batchId: Int): BatchEntity

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME} WHERE ${BatchEntity.Columns.COURSE_ID} = :courseId")
    fun getAllBatchesByCourse(courseId: Int): List<BatchEntity>

    @Insert
    fun addBatch(batch: BatchEntity)

    @Query("""
        SELECT b.batchId, b.courseId, c.courseName, b.subjectId, s.subjectName, b.teacherId, t.teacherFirstName as teacherName, b.batchTitle, b.batchFee, b.batchStartDate, b.batchEndDate, b.batchStartTime, b.batchEndTime FROM ${BatchEntity.TABLE_NAME} b JOIN ${CourseEntity.TABLE_NAME} c ON b.${BatchEntity.Columns.COURSE_ID} = c.${CourseEntity.Columns.COURSE_ID} JOIN ${SubjectEntity.TABLE_NAME} s ON b.${BatchEntity.Columns.SUBJECT_ID} = s.${SubjectEntity.Columns.SUBJECT_ID} JOIN ${TeacherEntity.TABLE_NAME} t ON b.${BatchEntity.Columns.TEACHER_ID} = t.${TeacherEntity.Columns.TEACHER_ID}
        """)
    fun getBatchList() : List<BatchDetailEntity>

    @Query("SELECT * FROM ${BatchEntity.TABLE_NAME} WHERE ${BatchEntity.Columns.COURSE_ID} = :courseId AND ${BatchEntity.Columns.SUBJECT_ID} = :subjectId")
    fun getFilteredBatchList(courseId: Int, subjectId: Int): List<BatchEntity>

}