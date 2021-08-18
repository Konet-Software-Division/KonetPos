package com.konet.konetpos.network.repository


import com.konet.konetpos.domain.repository.AuthRepository
import com.konet.konetpos.network.remote.ApiHelper
import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse

class AuthRepositoryImpl(
    private val apiHelper: ApiHelper
) : AuthRepository {


    override suspend fun signIn(request: LoginRequest): LoginResponse {
        return apiHelper.login(request)
    }


}