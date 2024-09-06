package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchDetail
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.BatchTimeTable
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.CreateBatchTimeTableUseCase
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.GetBatchTimeTableUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatchTimeTableListViewModel @Inject constructor(
    private val batchTimeTableListUseCase: GetBatchTimeTableUseCase,
    private val createBatchTimeTableUseCase: CreateBatchTimeTableUseCase
) : ViewModel() {

    init {
        Log.i("BatchTimeTableListViewModel", "BatchTimeTableListViewModel Init")
    }

    val batchResponse = MutableLiveData<Resource<List<BatchTimeTable>>>()
    val createBatchResponse = MutableLiveData<Resource<Boolean>>()

    fun getBatchTimeTableList(batchId: Int) {
        Log.i("BatchTimeTableListViewModel", "BatchTimeTableListViewModel getBatchList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = GetBatchTimeTableUseCase.Request()
            request.setRequestModel(batchId)
            val response = batchTimeTableListUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("BatchTimeTableListViewModel", "getBatchTimeTableList Success")
                        batchResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("BatchTimeTableListViewModel", "getBatchTimeTableList else")
                    }
                }
            }
        }
    }

    fun createBatchTimeTableList(batchId: Int) {
        Log.i("BatchTimeTableListViewModel", "BatchTimeTableListViewModel createBatchTimeTableList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = CreateBatchTimeTableUseCase.Request()
            request.setRequestModel(batchId)
            val response = createBatchTimeTableUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("BatchTimeTableListViewModel", "getBatchTimeTableList Success")
                        createBatchResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("BatchTimeTableListViewModel", "getBatchTimeTableList else")
                    }
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("BatchListViewModel" , "BatchListViewModel onCleared")
    }
}