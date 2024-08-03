package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.StudentListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentListViewModel @Inject constructor(
    private val studentListUseCase: StudentListUseCase
) : ViewModel() {

    init {
        Log.i("StudentListViewModel", "StudentListViewModel Init")
    }

    val studentResponse = MutableLiveData<Resource<List<Student>>>()

    fun getStudentList() {
        Log.i("StudentListViewModel", "StudentListViewModel getStudentList")
        viewModelScope.launch (Dispatchers.IO) {
            val request = StudentListUseCase.Request()
            val response = studentListUseCase.executeUseCase(request)
            viewModelScope.launch (Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("StudentListViewModel", "getStudentList Success")
                        studentResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("StudentListViewModel", "getStudentList else")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("StudentListViewModel" , "StudentListViewModel onCleared")
    }

}