package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddCourseViewModel @Inject constructor(
    private val addCourseUseCase: AddCourseUseCase
) : ViewModel() {

    init {
        Log.i("AddCourseViewModel", "AddCourseViewModel Init")
    }

    val courseResponse = MutableLiveData<Resource<Long>>()


    fun addCourse(requestModel: Course) {
        Log.i("AddCourseViewModel", "AddCourseViewModel addCourse")
        viewModelScope.launch(Dispatchers.IO) {
            val request = AddCourseUseCase.Request()
            request.setRequestModel(requestModel)
            val response = addCourseUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when (response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("AddCourseViewModel", "AddCourseViewModel addCourse Success")
                        courseResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("AddCourseViewModel", "AddCourseViewModel addCourse else")
                        courseResponse.postValue(Resource.Success(0))

                    }
                }
            }

        }
    }

}