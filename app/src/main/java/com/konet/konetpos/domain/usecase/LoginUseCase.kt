package com.konet.konetpos.domain.usecase

import com.konet.konetpos.domain.repository.AuthRepository
import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetails
import com.konet.konetpos.network.response.WalletDetailsResponse

import com.konet.konetpos.utils.HawkHelper
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val hawkHelper: HawkHelper
) {

    sealed class Result {
        object Loading : Result()
        data class Success(val response: LoginResponse) : Result()
        data class Failure(val throwable: Throwable) : Result()
    }

    suspend fun execute(request: LoginRequest): Result {
        return try {
            //refresh token
            val loginResponse = authRepository.signIn(request)
            hawkHelper.setToken(loginResponse.data.user.token)
//
//            //get user detail
//            val accountResponse = authRepository.getAccountDetails()
//            accountResponse.let{
//                hawkHelper.setUserDetail(it)
//            }
            val accountResponse = authRepository.getAccountDetails()

            hawkHelper.setUserDetail(WalletDetailsResponse(WalletDetails(accountResponse.wallet.user,
                accountResponse.wallet.available_balance)))

            Result.Success(loginResponse)
        } catch (exception: Exception) {
            Result.Failure(exception)
        }
    }
}