package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.TeacherEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeacherEntityLocalMapper
@Inject constructor() : BaseMapper<Teacher, TeacherEntity>() {

    override fun map(entity: TeacherEntity): Teacher {
        return Teacher(
            teacherId = entity.teacherId,
            teacherFirstName = entity.teacherFirstName,
            teacherMiddleName = entity.teacherMiddleName,
            teacherLastName = entity.teacherLastName,
            teacherDesignation = entity.teacherDesignation,
            teacherQualification = entity.teacherQualification,
            teacherDoB = entity.teacherDoB,
            teacherExperience = entity.teacherExperience,
            teacherGender = entity.teacherGender,
            teacherDateOfJoining = entity.teacherDateOfJoining,
            teacherPhoneNumber = entity.teacherPhoneNumber,
            teacherEmail = entity.teacherEmail,
            teacherSalary = entity.teacherSalary,
            teacherStatus = entity.teacherStatus
        )
    }

    override fun reverse(model: Teacher): TeacherEntity {
        return TeacherEntity(
            teacherId = model.teacherId,
            teacherFirstName = model.teacherFirstName,
            teacherMiddleName = model.teacherMiddleName,
            teacherLastName = model.teacherLastName,
            teacherEmail = model.teacherEmail,
            teacherDesignation = model.teacherDesignation,
            teacherQualification = model.teacherQualification,
            teacherDoB = model.teacherDoB,
            teacherExperience = model.teacherExperience,
            teacherGender = model.teacherGender,
            teacherDateOfJoining = model.teacherDateOfJoining,
            teacherPhoneNumber = model.teacherPhoneNumber,
            teacherSalary = model.teacherSalary,
            teacherStatus = model.teacherStatus
        )
    }
}