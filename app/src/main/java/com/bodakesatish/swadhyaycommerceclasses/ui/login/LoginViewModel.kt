package com.bodakesatish.swadhyaycommerceclasses.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bodakesatish.swadhyaycommerceclasses.common.CoroutineHelper
import com.bodakesatish.swadhyaycommerceclasses.common.Resource
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.UserRequestModel
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.SocialMediaSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val socialMediaSignInUseCase: SocialMediaSignInUseCase
) : ViewModel() {

    val singInResponse = MutableLiveData<Resource<Any>>()
    private val scope = CoroutineHelper().getScope()

    fun socialMediaSignIn(userRequestModel: UserRequestModel) {
        Log.i("In LoginViewModel","socialMediaSignIn")
        scope.launch {
            val requestModel = SocialMediaSignInUseCase.Request()
            requestModel.setRequestModel(userRequestModel)
            val response = socialMediaSignInUseCase.executeUseCase(requestModel)
            scope.launch(Dispatchers.Main) {
                when (response.getResponseCode()) {
                    is ResponseCode.Success -> {
                        singInResponse.postValue(Resource.Success(response.getData()!!))
                        Log.i("In LoginViewModel","socialMediaSignIn Success")
                    }
                    is ResponseCode.Authentication -> {
                        singInResponse.postValue(Resource.Error("Please enter valid credentials"))
                        Log.i("In LoginViewModel","socialMediaSignIn Fail")
                    }
                    else -> {
                        singInResponse.postValue(Resource.Error("Something went wrong.Please try again"))
                        Log.i("In LoginViewModel","socialMediaSignIn Else")
                    }
                }
            }
        }
    }

}