package com.bodakesatish.swadhyaycommerceclasses.data.mapper.local

import com.bodakesatish.swadhyaycommerceclasses.data.mapper.base.BaseMapper
import com.bodakesatish.swadhyaycommerceclasses.data.source.local.entity.StudentEntity
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StudentEntityLocalMapper
@Inject constructor() : BaseMapper<Student, StudentEntity>() {

    override fun map(entity: StudentEntity): Student {
        return Student(
            studentId = entity.studentId,
            courseId = entity.courseId,
            studentFirstName = entity.studentFirstName,
            studentMiddleName = entity.studentMiddleName,
            studentLastName = entity.studentLastName,
            studentDoB = entity.studentDoB,
            studentGender = entity.studentGender,
            studentAddress = entity.studentAddress,
            studentPhoneNumber = entity.studentPhoneNumber,
            studentEmail = entity.studentEmail,
            studentParentName = entity.studentParentName,
            studentParentPhoneNumber = entity.studentParentPhoneNumber,
            studentAdmissionDate = entity.studentAdmissionDate,
            studentIsActive = entity.studentIsActive
        )
    }

    override fun reverse(model: Student): StudentEntity {
        return StudentEntity(
            studentId = model.studentId,
            courseId = model.courseId,
            studentFirstName = model.studentFirstName,
            studentMiddleName = model.studentMiddleName,
            studentLastName = model.studentLastName,
            studentDoB = model.studentDoB,
            studentGender = model.studentGender,
            studentAddress = model.studentAddress,
            studentPhoneNumber = model.studentPhoneNumber,
            studentEmail = model.studentEmail,
            studentParentName = model.studentParentName,
            studentParentPhoneNumber = model.studentParentPhoneNumber,
            studentAdmissionDate = model.studentAdmissionDate,
            studentIsActive = model.studentIsActive
        )
    }
}