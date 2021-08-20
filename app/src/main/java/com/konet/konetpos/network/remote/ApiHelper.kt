package com.konet.konetpos.network.remote

import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse
import com.konet.konetpos.network.response.WalletDetailsResponse

interface ApiHelper {

    suspend fun login(request: LoginRequest): LoginResponse
    suspend fun walletdetails(): WalletDetailsResponse

}