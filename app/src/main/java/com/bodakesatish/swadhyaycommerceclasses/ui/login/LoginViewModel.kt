package com.bodakesatish.swadhyaycommerceclasses.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bodakesatish.swadhyaycommerceclasses.util.Resource
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.UserRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val socialMediaSignInUseCase: LoginUseCase
) : ViewModel() {

    private val _loginResponse = MutableLiveData<Resource<Any>>()
    val loginResponse : LiveData<Resource<Any>> = _loginResponse

    fun login(userName: String, password: String) {
        Log.i("In LoginViewModel","socialMediaSignIn")
        viewModelScope.launch(Dispatchers.IO) {
            val requestModel = LoginUseCase.Request()
            requestModel.setRequestModel(UserRequestModel(userName,password))
            val response = socialMediaSignInUseCase.executeUseCase(requestModel)
            viewModelScope.launch(Dispatchers.Main) {
                when (response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        _loginResponse.value = Resource.Success(response.getData()!!)
                        Log.i("In LoginViewModel","socialMediaSignIn Success")
                    }
                    is ResponseCode.Authentication -> {
                        _loginResponse.postValue(Resource.Error("Please enter valid credentials"))
                        Log.i("In LoginViewModel","socialMediaSignIn Fail")
                    }
                    else -> {
                        _loginResponse.postValue(Resource.Error("Something went wrong.Please try again"))
                        Log.i("In LoginViewModel","socialMediaSignIn Else")
                    }
                }
            }
        }
    }

    fun setLoginResponse(response: Resource<Any>) {
        _loginResponse.value = response
    }


}