package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Teacher
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.TeacherListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBatchViewModel @Inject constructor(
    private val addBatchUseCase: AddBatchUseCase,
    private val courseListUseCase: CourseListUseCase,
    private val subjectUseCase: SubjectListUseCase,
    private val teacherListUseCase: TeacherListUseCase
) : ViewModel() {


    init {
        Log.i("AddBatchViewModel", "AddBatchViewModel Init")
    }

    val batchResponse = MutableLiveData<Resource<Boolean>>()

    val courseResponse = MutableLiveData<Resource<List<Course>>>()

    val subjectResponse = MutableLiveData<Resource<List<Subject>>>()

    val teacherResponse = MutableLiveData<Resource<List<Teacher>>>()

    fun addBatch(batch: Batch) {
        Log.i("AddBatchViewModel", "AddBatchViewModel addBatch")
        viewModelScope.launch(Dispatchers.IO) {
            val request = AddBatchUseCase.Request()
            request.setRequestModel(batch)
            val response = addBatchUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("AddBatchViewModel", "AddBatchViewModel addBatch Success")
                        batchResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("AddBatchViewModel", "AddBatchViewModel addBatch else")
                        batchResponse.postValue(Resource.Success(false))
                    }
                }
            }
        }
    }

    fun getSubjectList(courseId: Int) {
        Log.i("AddBatchViewModel", "AddBatchViewModel getSubjectList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = SubjectListUseCase.Request()
            request.setRequestModel(courseId)
            val response = subjectUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        subjectResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i("AddBatchViewModel", "getSubjectList Success")
                    }
                    else -> {
                        Log.i("AddBatchViewModel", "getSubjectList else")
                    }
                }
            }
        }
    }

    fun getCourseList() {
        Log.i("AddBatchViewModel" , "AddBatchViewModel getCourseList")
        viewModelScope.launch(Dispatchers.IO) {
            val response = courseListUseCase.executeUseCase(CourseListUseCase.Request())
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("AddBatchViewModel" , "getCourseList Success")
                        courseResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("AddBatchViewModel" , "getCourseList else")
                    }
                }
            }
        }
    }

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
        Log.i("AddBatchViewModel" , "AddBatchViewModel onCleared")
    }

}