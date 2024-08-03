package com.bodakesatish.swadhyaycommerceclasses.ui.subject

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Subject
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddSubjectUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SubjectListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubjectViewModel @Inject constructor(
    private val subjectUseCase: SubjectListUseCase,
    private val addSubjectUseCase: AddSubjectUseCase
) : ViewModel() {

    init {
        Log.i("SubjectViewModel", "SubjectViewModel Init")
    }

    val subjectResponse = MutableLiveData<Resource<List<Subject>>>()

    private var courseId = 0

    fun getSubjectList(courseId: Int) {
        Log.i("SubjectViewModel", "SubjectViewModel getSubjectList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = SubjectListUseCase.Request()
            request.setRequestModel(courseId)
            val response = subjectUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        subjectResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i("SubjectViewModel", "getSubjectList Success")
                    }
                    else -> {
                        Log.i("SubjectViewModel", "getSubjectList else")
                    }
                }
            }
        }
    }

    fun addSubject(subject: Subject) {
        Log.i("SubjectViewModel", "SubjectViewModel addSubject")
        viewModelScope.launch(Dispatchers.IO) {
            val request = AddSubjectUseCase.Request()
            request.setRequestModel(subject)
            val response = addSubjectUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        getSubjectList(courseId)
                        Log.i("SubjectViewModel", "addSubject Success")
                    }
                    else -> {
                        Log.i("SubjectViewModel", "addSubject Else")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SubjectViewModel" , "SubjectViewModel onCleared")
    }

    fun setCourseId(courseId: Int) {
        this.courseId = courseId
    }

}