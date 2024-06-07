package com.bodakesatish.swadhyaycommerceclasses.data.mapper.base

import com.bodakesatish.swadhyaycommerceclasses.data.source.base.BaseOutput
import com.bodakesatish.swadhyaycommerceclasses.data.source.base.ResponseCode
import com.bodakesatish.swadhyaycommerceclasses.domain.model.response.ResponseCode.*
import com.bodakesatish.swadhyaycommerceclasses.domain.usecases.base.BaseUseCase

class BaseOutputRemoteMapper<T : Any> {

    fun mapBaseOutput(output: BaseOutput<T>, response: BaseUseCase.Response<T>) {
        when (output) {
            is BaseOutput.Success -> {
                when (output.code) {
                    ResponseCode.SUCCESS -> {
                        mapSuccessOutput(output, response)
                    }
                    ResponseCode.EMPTY -> {
                        mapEmptyOutput(output, response)
                    }
                }
            }
            is BaseOutput.Error -> {
                mapErrorOutput(output, response)
            }
        }
    }

    suspend fun mapBaseOutput(
        output: BaseOutput<T>,
        response: BaseUseCase.Response<T>,
        executeOnSuccess: suspend (T) -> T
    ) {
        when (output) {
            is BaseOutput.Success -> {
                when (output.code) {
                    ResponseCode.SUCCESS -> {
                        val data = executeOnSuccess.invoke(output.output!!)
                        mapSuccessOutput(data, response)
                    }
                    ResponseCode.EMPTY -> {
                        mapEmptyOutput(output, response)
                    }
                }
            }
            is BaseOutput.Error -> {
                mapErrorOutput(output, response)
            }
        }
    }

    suspend fun mapBaseOutput(
        output: BaseOutput<T>,
        response: BaseUseCase.Response<T>,
        executeOnSuccess: suspend (T) -> T,
        executeOnError: suspend () -> T
    ) {
        when (output) {
            is BaseOutput.Success -> {
                when (output.code) {
                    ResponseCode.SUCCESS -> {
                        val data = executeOnSuccess.invoke(output.output!!)
                        mapSuccessOutput(data, response)
                    }
                    ResponseCode.EMPTY -> {
                        mapEmptyOutput(output, response)
                    }
                }
            }
            is BaseOutput.Error -> {
                mapErrorOutput(output, response, executeOnError)
            }
        }
    }

    private fun mapSuccessOutput(output: BaseOutput.Success<T>, response: BaseUseCase.Response<T>) {
        response.setData(output.output)
        response.setResponseCode(Success)
    }

    private fun mapSuccessOutput(data: T, response: BaseUseCase.Response<T>) {
        response.setData(data)
        response.setResponseCode(Success)
    }

    private fun mapEmptyOutput(output: BaseOutput.Success<T>, response: BaseUseCase.Response<T>) {
        response.setData(output.output)
        response.setResponseCode(Empty)
    }

    private fun mapErrorOutput(output: BaseOutput.Error, response: BaseUseCase.Response<T>) {
        when (output.code) {
            ResponseCode.NETWORK_ERROR -> {
                response.setResponseCode(Network)
            }
            ResponseCode.AUTHENTICATION_FAILED -> {
                response.setResponseCode(Authentication)
            }
            ResponseCode.NOT_FOUND -> {
                response.setResponseCode(NOT_FOUND)
            }
            ResponseCode.BAD_REQUEST -> {
                response.setResponseCode(BAD_REQUEST)
            }
            ResponseCode.DUPLICATE_USER -> {
                response.setResponseCode(DUPLICATE_USER)
            }
            else -> {
                response.setResponseCode(Fail)
            }
        }
    }

    private suspend fun mapErrorOutput(
        output: BaseOutput.Error,
        response: BaseUseCase.Response<T>,
        executeOnError: suspend () -> T
    ) {
        val data = executeOnError.invoke()
        response.setData(data)
        when (output.code) {
            ResponseCode.NETWORK_ERROR -> {
                response.setResponseCode(Network)
            }
            ResponseCode.AUTHENTICATION_FAILED -> {
                response.setResponseCode(Authentication)
            }
            ResponseCode.UNKNOWN_ERROR -> {
                response.setResponseCode(Fail)
            }
            ResponseCode.NOT_FOUND -> {
                response.setResponseCode(NOT_FOUND)
            }
            ResponseCode.BAD_REQUEST -> {
                response.setResponseCode(BAD_REQUEST)
            }
            ResponseCode.DUPLICATE_USER -> {
                response.setResponseCode(DUPLICATE_USER)
            }
            else -> {
                response.setResponseCode(Fail)
            }
        }
    }

}