package com.bodakesatish.swadhyaycommerceclasses.ui.student

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.AddStudentBatchRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Student
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddStudentUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.FilteredBatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddStudentViewModel @Inject constructor(
    private val addStudentUseCase: AddStudentUseCase,
    private val courseListUseCase: CourseListUseCase,
    private val subjectUseCase: SubjectListUseCase,
    private val filterBatchListUseCase: FilteredBatchListUseCase
) : ViewModel() {

    private val tag = "AddStudentViewModel"

    init {
        Log.i(tag,"AddStudentViewModel Init")
    }


    private val _addStudentResponse = MutableLiveData<Resource<Boolean>>()
    val addStudentResponse : LiveData<Resource<Boolean>> = _addStudentResponse

    val courseResponse = MutableLiveData<Resource<List<Course>>>()

    val subjectResponse = MutableLiveData<Resource<List<Subject>>>()

    val filteredBatchListResponse = MutableLiveData<Resource<List<Batch>>>()

    fun addStudent(student: Student) {
        Log.i(tag,"addStudent")
        viewModelScope.launch(Dispatchers.IO) {
            val request = AddStudentUseCase.Request()
            request.setRequestModel(student)
            val response = addStudentUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        _addStudentResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i(tag,"addStudent Success")
                    }
                    else -> {
                        Log.i(tag,"addStudent else")
                    }
                }
            }
        }
    }

    fun getCourseList() {
        Log.i(tag , "getCourseList")
        viewModelScope.launch(Dispatchers.IO) {
            val response = courseListUseCase.executeUseCase(CourseListUseCase.Request())
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i(tag , "getCourseList Success")
                        courseResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i(tag , "getCourseList else")
                    }
                }
            }
        }
    }

    fun getSubjectList(courseId: Int) {
        Log.i(tag, "getSubjectList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = SubjectListUseCase.Request()
            request.setRequestModel(courseId)
            val response = subjectUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        subjectResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i(tag, "getSubjectList Success")
                    }
                    else -> {
                        Log.i(tag, "getSubjectList else")
                    }
                }
            }
        }
    }

    fun getFilteredBatchList(courseId: Int, subjectId: Int) {
        Log.i(tag, "getFilteredBatchList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = FilteredBatchListUseCase.Request()
            request.setRequestModel(AddStudentBatchRequestModel(courseId,subjectId))
            Log.i(tag, "AddStudentBatchRequestModel->${request.getRequestModel()}")

            val response = filterBatchListUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        filteredBatchListResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i(tag, "getFilteredBatchList Success")
                    }
                    else -> {
                        Log.i(tag, "getFilteredBatchList else")
                    }
                }
            }
        }
    }

}