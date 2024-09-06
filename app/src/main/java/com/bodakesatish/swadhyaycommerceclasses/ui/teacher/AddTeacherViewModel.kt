package com.bodakesatish.swadhyaycommerceclasses.ui.teacher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddTeacherUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddTeacherViewModel @Inject constructor(
    private val addTeacherUseCase: AddTeacherUseCase
) : ViewModel() {

    init {
        Log.i("AddTeacherViewModel", "AddTeacherViewModel Init")
    }


    private val _addTeacherResponse = MutableLiveData<Resource<Boolean>>()
    val addTeacherResponse : LiveData<Resource<Boolean>> = _addTeacherResponse

    fun addTeacher(teacher: Teacher) {
        Log.i("AddTeacherViewModel", "AddTeacherViewModel addTeacher")
        viewModelScope.launch (Dispatchers.IO) {
            val request = AddTeacherUseCase.Request()
            request.setRequestModel(teacher)
            val response = addTeacherUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when (response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        _addTeacherResponse.postValue(Resource.Success(true))
                        Log.i("AddTeacherViewModel", "AddTeacherViewModel addTeacher Success")
                    }
                    else -> {
                        _addTeacherResponse.postValue(Resource.Success(false))
                        Log.i("AddTeacherViewModel", "AddTeacherViewModel addTeacher else")
                    }
                }
            }

        }

    }

    override fun onCleared() {
        Log.i("AddTeacherViewModel", "AddTeacherViewModel onCleared")
        super.onCleared()
    }

}