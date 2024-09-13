package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import android.util.Log
import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.CourseEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourseEntityLocalMapper
@Inject constructor() : BaseMapper<Course, CourseEntity>() {

    private val tag = this.javaClass.simpleName

    override fun reverse(model: Course): CourseEntity {

        Log.i("In $tag", "reverse $model")

        return CourseEntity(
            courseId = model.courseId,
            courseName = model.courseName
//            courseDuration = model.courseDuration,
//            courseFee = model.courseFee,
//            courseDescription = model.courseDescription,
//            courseStartDate = model.courseStartDate,
//            courseEndDate = model.courseEndDate
        )
    }

    override fun map(entity: CourseEntity): Course {
        Log.i("In $tag", "map $entity")
        return Course(
            courseId = entity.courseId,
            courseName = entity.courseName
//            courseDuration = entity.courseDuration,
//            courseFee = entity.courseFee,
//            courseDescription = entity.courseDescription,
//            courseStartDate = entity.courseStartDate,
//            courseEndDate = entity.courseEndDate
        )
    }

}