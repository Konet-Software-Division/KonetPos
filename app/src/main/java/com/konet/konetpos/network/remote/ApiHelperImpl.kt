package com.konet.konetpos.network.remote

import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.SafeApiRequest

import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.WalletDetailsResponse
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val api: API) : ApiHelper, SafeApiRequest() {

    override suspend fun login(request: LoginRequest): LoginResponse {
        return apiRequest { api.signIn(request) }
    }

    override suspend fun walletdetails(): WalletDetailsResponse {
        return apiRequest { api.walletDetails() }
    }

}