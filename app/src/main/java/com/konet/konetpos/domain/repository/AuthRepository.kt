package com.konet.konetpos.domain.repository

import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse


interface AuthRepository {

    suspend fun signIn(request: LoginRequest): LoginResponse

//    suspend fun refreshToken(refresh_token: String): LoginResponse

//    suspend fun getAccountDetails(): ProfileResponse

}