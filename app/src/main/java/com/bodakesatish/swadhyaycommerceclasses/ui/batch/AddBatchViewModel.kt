package com.bodakesatish.swadhyaycommerceclasses.ui.batch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.Batch
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.AddBatchUseCase
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBatchViewModel @Inject constructor(
    private val addBatchUseCase: AddBatchUseCase
) : ViewModel() {


    init {
        Log.i("AddBatchViewModel", "AddBatchViewModel Init")
    }

    val batchResponse = MutableLiveData<Resource<Boolean>>()

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

}