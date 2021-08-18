package com.konet.konetpos.network.remote

import com.konet.konetpos.network.request.LoginRequest
import com.konet.konetpos.network.response.LoginResponse

interface ApiHelper {

    suspend fun login(request: LoginRequest): LoginResponse
}