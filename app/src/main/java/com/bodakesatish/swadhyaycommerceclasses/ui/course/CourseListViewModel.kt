package com.bodakesatish.swadhyaycommerceclasses.ui.course

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Course
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CourseListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.PagedCourseUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseListViewModel @Inject constructor(
    private val courseListUseCase: CourseListUseCase,
    private val pagedCourseUseCase: PagedCourseUseCase
) : ViewModel() {

    init {
        Log.i("CourseListViewModel" , "CourseListViewModel Init")
    }

    private val _courseResponse: MutableStateFlow<List<Course>?> = MutableStateFlow(null)
    val courseResponse: StateFlow<List<Course>?>
        get() = _courseResponse

    private val _productsFlow = MutableStateFlow<PagingData<Course>>(PagingData.empty())
    val productsFlow: StateFlow<PagingData<Course>> = _productsFlow.asStateFlow()

    fun getCourseList() {
        Log.i("CourseListViewModel" , "CourseListViewModel getCourseList")
        viewModelScope.launch(Dispatchers.IO) {
            val response = courseListUseCase.executeUseCase(CourseListUseCase.Request())
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("CourseListViewModel" , "getCourseList Success")
                        response.getData()?.collect {
                            _courseResponse.emit(it)
                        }
                    }
                    else -> {
                        Log.i("CourseListViewModel" , "getCourseList else")
                    }
                }
            }
        }
    }

    fun getPagedCourseList() {
        Log.i("CourseListViewModel" , "CourseListViewModel getPagedCourseList")
        viewModelScope.launch {
            val response = pagedCourseUseCase.executeUseCase(PagedCourseUseCase.Request())
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("CourseListViewModel" , "getCourseList Success")
                        response.getData()?.cachedIn(viewModelScope)?.collectLatest { pagingData ->
                            Log.i("CourseListViewModel" , "getCourseList collectLatest $pagingData")
                            _productsFlow.value = pagingData
                        }
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