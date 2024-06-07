package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import javax.inject.Inject

data class UserRequestModel @Inject constructor(
    var full_name: String = "",
    var email_id: String = ""
) : BaseRequest