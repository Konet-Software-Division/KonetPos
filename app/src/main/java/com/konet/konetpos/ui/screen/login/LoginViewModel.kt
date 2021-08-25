package com.konet.konetpos.ui.screen.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.konet.konetpos.domain.usecase.LoginUseCase
import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.ui.base.BaseViewModel
import com.konet.konetpos.utils.HawkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val hawkHelper: HawkHelper
) : BaseViewModel<LoginView>() {

    fun doLogin(phone: String, pin: String, device:String) {
        handleLoginResult(LoginUseCase.Result.Loading)

        val loginRequest = LoginRequest(
            phone = phone,
            pin = pin,
            device=device
        )

        viewModelScope.launch {
            handleLoginResult(loginUseCase.execute(loginRequest))
        }
    }

    private fun handleLoginResult(result: LoginUseCase.Result) {
        when (result) {
            is LoginUseCase.Result.Loading -> {
                getView()?.showProgressDialog(true)
            }
            is LoginUseCase.Result.Success -> {
                getView()?.showProgressDialog(false)
                hawkHelper.setToken(result.response.data.user.token)
//                hawkHelper.setRefreshToken(result.response.refreshToken)
                getView()?.loginSuccess()
            }
            is LoginUseCase.Result.Failure -> {
                Timber.e(result.throwable)
                Log.i("PPPPPPPP",result.throwable.message.toString())
                getView()?.showProgressDialog(false)
                getView()?.handleError(result.throwable)
            }
        }
    }
}