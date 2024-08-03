package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentViewModel @Inject constructor(
    private val addStudentUseCase: AddStudentUseCase
) : ViewModel() {

    init {
        Log.i("AddStudentViewModel","AddStudentViewModel Init")
    }

    fun addStudent(student: Student) {
        Log.i("AddStudentViewModel","AddStudentViewModel addStudent")
        viewModelScope.launch(Dispatchers.IO) {
            val request = AddStudentUseCase.Request()
            request.setRequestModel(student)
            val response = addStudentUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("AddStudentViewModel","AddStudentViewModel addStudent Success")
                    }
                    else -> {
                        Log.i("AddStudentViewModel","AddStudentViewModel addStudent else")
                    }
                }
            }
        }
    }

}