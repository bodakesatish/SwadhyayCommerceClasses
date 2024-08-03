package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseListViewModel @Inject constructor(
    private val courseListUseCase: CourseListUseCase
) : ViewModel() {

    init {
        Log.i("CourseListViewModel" , "CourseListViewModel Init")
    }

    val courseResponse = MutableLiveData<Resource<List<Course>>>()

    fun getCourseList() {
        Log.i("CourseListViewModel" , "CourseListViewModel getCourseList")
        viewModelScope.launch(Dispatchers.IO) {
            val response = courseListUseCase.executeUseCase(CourseListUseCase.Request())
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("CourseListViewModel" , "getCourseList Success")
                        courseResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("CourseListViewModel" , "getCourseList else")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("CourseListViewModel" , "CourseListViewModel onCleared")
    }
}