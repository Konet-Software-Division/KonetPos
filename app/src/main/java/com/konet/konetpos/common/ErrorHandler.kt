package com.konet.konetpos.common

import android.content.Context
import com.konet.konetpos.utils.HawkHelper
import com.konet.konetpos.utils.util.ApiException
import com.google.gson.Gson
import com.konet.konetpos.R
import java.net.HttpURLConnection
import javax.inject.Inject


class ErrorHandler @Inject constructor() {

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var hawkHelper: HawkHelper

    fun handle(
        throwable: Throwable,
        notification: ErrorNotification?,
        option: Any?,
        context: Context
    ) {
        when (throwable) {
            is ApiException -> {
                val errorResponse = gson.fromJson(throwable.message, ErrorResponse::class.java)
                when (errorResponse.status) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> {
                        if (errorResponse.message != null &&
                            (errorResponse.message.isNotEmpty() || errorResponse.message == "Bad credentials.")
                        ) {
                            notification?.notifyError(errorResponse.message, throwable, option)
                        } else {
                            handleErrorForbidden(notification)
                        }
                    }
                    HttpURLConnection.HTTP_BAD_REQUEST -> {
                        if (errorResponse.data?.errors?.message != null && errorResponse.data.errors.message.isNotEmpty()) {
                            notification?.notifyError(errorResponse.data.errors.message, throwable, option)
                        } else {
                            if (errorResponse.message == "Expired JWT Token") {
                                handleErrorForbidden(notification)
                            } else {
                                notification?.notifyError(errorResponse.message!!, throwable, option)
                            }
                        }
                    }
                    HttpURLConnection.HTTP_FORBIDDEN -> {
                        if (errorResponse.message == "Expired JWT Token") {
                            handleErrorForbidden(notification)
                        } else {
                            notification?.notifyError(errorResponse.message!!, throwable, option)
                        }
                    }
                    else -> {
                        notification?.notifyError(
                            context.getString(R.string.unknown_error),
                            throwable,
                            option,
                            ErrorNotification.AfterNotify.SYSTEM_ERROR
                        )
                    }
                }
            }
            else -> {
                notification?.notifyError(
                    context.getString(R.string.unknown_error),
                    throwable,
                    option,
                    ErrorNotification.AfterNotify.SYSTEM_ERROR
                )
            }
        }
    }

    private fun handleErrorForbidden(notification: ErrorNotification?) {
//        val userDetail = hawkHelper.getUserDetail()
//        val token = hawkHelper.getToken()
//        val refreshToken = hawkHelper.getRefreshToken()
//
//        if (userDetail != null && token.isNotEmpty() && refreshToken.isNotEmpty()) {
//            Coroutines.io {
////                handleRefreshTokenResult(refreshTokenUseCase.execute(refreshToken), notification)
//            }
//        } else {
//            notification?.notifyError("", null, null, ErrorNotification.AfterNotify.LOGOUT)
//        }
    }

//    private fun handleRefreshTokenResult(result: RefreshTokenUseCase.Result, notification: ErrorNotification?) {
//        when (result) {
//            is RefreshTokenUseCase.Result.Loading -> {
//                //do nothing
//            }
//            is RefreshTokenUseCase.Result.Success -> {
//                hawkHelper.setToken(result.response.data.token)
//                hawkHelper.setRefreshToken(result.response.refreshToken)
//                Timber.d("Refresh token successfully!")
//            }
//            is RefreshTokenUseCase.Result.Failure -> {
//                notification?.notifyError("", result.throwable, null,
//                    ErrorNotification.AfterNotify.LOGOUT
//                )
//            }
//        }
//    }
}