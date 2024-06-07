package com.bodakesatish.swadhyaycommerceclasses.domain.model.response

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse

open class AuthToken : BaseResponse {
    var id : Int = 0
    var userId : Int = 0
    var token: String = ""
    var expiration: Long = 0
}