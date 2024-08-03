package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import javax.inject.Inject

data class UserRequestModel(
    var username: String = "",
    var password: String = ""
) : BaseRequest