package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.BatchListUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatchListViewModel @Inject constructor(
    private val batchListUseCase: BatchListUseCase
) : ViewModel() {

    init {
        Log.i("BatchListViewModel", "BatchListViewModel Init")
    }

    val batchResponse = MutableLiveData<Resource<List<Batch>>>()

    fun getBatchList(courseId : Int) {
        Log.i("BatchListViewModel", "BatchListViewModel getBatchList")
        viewModelScope.launch(Dispatchers.IO) {
            val request = BatchListUseCase.Request()
            request.setRequestModel(courseId)
            val response = batchListUseCase.executeUseCase(request)
            viewModelScope.launch(Dispatchers.Main) {
                when(response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        Log.i("BatchListViewModel", "getBatchList Success")
                        batchResponse.postValue(Resource.Success(response.getData()!!))
                    }
                    else -> {
                        Log.i("BatchListViewModel", "getBatchList else")
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