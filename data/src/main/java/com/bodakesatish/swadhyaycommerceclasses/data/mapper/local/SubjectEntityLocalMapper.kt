package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.SubjectEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectEntityLocalMapper
@Inject constructor() : BaseMapper<Subject, SubjectEntity>(){

    override fun map(entity: SubjectEntity): Subject {
        return Subject(
            subjectId = entity.subjectId,
            courseId = entity.courseId,
            subjectName = entity.subjectName,
            subjectFee = entity.subjectFee
        )
    }

    override fun reverse(model: Subject): SubjectEntity {
        return SubjectEntity(
            subjectId = model.subjectId,
            courseId = model.courseId,
            subjectName = model.subjectName,
            subjectFee = model.subjectFee
        )
    }

}