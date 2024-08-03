package com.bodakesatish.swadhyaycommerceclasses.domain.model.request

import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseRequest
import com.bodakesatish.swadhyaycommerceclasses.domain.model.request.base.BaseResponse
import java.util.Date
import javax.inject.Inject

data class BatchRequestModel @Inject constructor(
    val batchId: Int,
    val courseId: Int,
    val batchName: String,
    val batchStartDate: Date,
    val batchEndDate: Date,
    val batchTime: Date,
): BaseRequest
