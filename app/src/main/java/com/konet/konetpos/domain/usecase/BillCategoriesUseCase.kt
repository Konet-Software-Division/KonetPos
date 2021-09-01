package com.konet.konetpos.domain.usecase

import com.konet.konetpos.domain.repository.AuthRepository
import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetails
import com.konet.konetpos.network.response.WalletDetailsResponse

import com.konet.konetpos.utils.HawkHelper
import javax.inject.Inject

class BillCategoryUseCase @Inject constructor(
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
            val billerCategoriesResponse = authRepository.billerCategories()


            Result.Success(billerCategoriesResponse)
        } catch (exception: Exception) {
            Result.Failure(exception)
        }
    }
}