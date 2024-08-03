package com.bodakesatish.swadhyaycommerceclasses.ui.teacher

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.TeacherListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TeacherListViewModel @Inject constructor(
    private val teacherListUseCase: TeacherListUseCase
) : ViewModel() {

    init {
        Log.i("TeacherListViewModel", "TeacherListViewModel Init")
    }

    val teacherResponse = MutableLiveData<Resource<List<Teacher>>>()

    fun getTeacherList() {
        Log.i("TeacherListViewModel", "TeacherListViewModel getTeacherList")
        viewModelScope.launch (Dispatchers.IO) {
            val request = TeacherListUseCase.Request()
            val response = teacherListUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("TeacherListViewModel", "getTeacherList Success")
                        teacherResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("TeacherListViewModel", "getTeacherList else")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("TeacherListViewModel" , "TeacherListViewModel onCleared")
    }

}